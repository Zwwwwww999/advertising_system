package com.alone.ad.advice;

import com.alone.ad.annotaion.IgnoreResponseAdvice;
import com.alone.ad.vo.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName CommonResponseDataAdvice
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/21 19:45
 * @Description CommonResponseDataAdvice
 * @Version 1.0
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 是否响应拦截
     * @param returnType 方法参数
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        /**
         * 类上被@IgnoreResponseAdvice修饰的忽略
         */
      if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){

          return false;
      }
        /**
         * 方法被修饰@IgnoreResponseAdvice
         */
        Method method = returnType.getMethod();

        if (!ObjectUtils.isEmpty(method)&&method.isAnnotationPresent(IgnoreResponseAdvice.class)){
          return false;
      }
        return true;
    }

    /**
     * 写入响应前操作
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse serverHttpResponse) {


        Result<Object> response = new Result<>(0,"");
        // 三种情况 1.body为null
        // 2. body为result 则不需要处理
        // 3.body为其他对象 需要包装成result
        if (null == body){
            return response;
        }else if (body instanceof Result){
            response =(Result<Object>) body;
        }else {
            response.setData(body);
        }
        return response;
    }
}
