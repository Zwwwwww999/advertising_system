package com.alone.ad.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.reactive.result.view.RequestContext;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @ClassName MyLogGateWayFilter
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/19 20:31
 * @Description MyLogGateWayFilter
 * @Version 1.0
 * 全局日志过滤器
 */
@Order(0)
@Slf4j
public class PreRequestFilter implements GlobalFilter {
    private final ObjectMapper mapper = new ObjectMapper();
    private final DataBufferFactory dataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        // 获取请求路径
        String path = request.getPath().pathWithinApplication().value();
        // 获取请求方法
        HttpMethod method = request.getMethod();
        // 请求参数载体
        StringBuilder builder = new StringBuilder();
        URI targetUrl = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);

        if (HttpMethod.GET.equals(method)){
            // 1Key对多个Value 类似Map<String,List<String>>
            MultiValueMap<String,String> queryParams = request.getQueryParams();
            try {
                // 请求参数,map转JSON
                builder.append(mapper.writeValueAsString(queryParams));
            } catch (JsonProcessingException e) {
                log.error(e.getMessage(), e);
            }
        }else if (HttpMethod.POST.equals(method)){
             //  获得请求体
            Flux<DataBuffer> body = request.getBody();
            ServerHttpRequest serverHttpRequest = request.mutate().uri(request.getURI()).build();
            // 获取请求体的参数对象并转为String格式
            body.subscribe(dataBuffer -> {
                InputStream inputStream = dataBuffer.asInputStream();
                try {
                    builder.append(StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8));
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            });
            request = new ServerHttpRequestDecorator(serverHttpRequest){
                @Override
                public Flux<DataBuffer> getBody() {
                    return Flux.just(dataBufferFactory.wrap(builder.toString().getBytes(StandardCharsets.UTF_8)));
                }
            };
        }
        // 获取请求地址
        InetSocketAddress remoteAddress = request.getRemoteAddress();
        return chain.filter(exchange.mutate().request(request).build()).then(Mono.fromRunnable(()->{
            ServerHttpResponse response = exchange.getResponse();
            HttpStatus statusCode = response.getStatusCode();
            log.info("请求路径\t{}\n远程IP地址\t{}\n请求方法\t{}\n请求参数\t{}\n目标URI\t{}\n响应码\t{}", path, remoteAddress, method, builder.toString(), targetUrl, statusCode);

        }));

    }



}
