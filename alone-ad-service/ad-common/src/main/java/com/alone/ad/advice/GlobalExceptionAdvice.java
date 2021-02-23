package com.alone.ad.advice;

import com.alone.ad.exception.AdException;
import com.alone.ad.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionAdvice
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/21 20:24
 * @Description GlobalExceptionAdvice
 * @Version 1.0
 * 统一异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public Result<String> handleExceptionHandler(HttpServletRequest request, AdException ex){
        Result<String> response = new Result<>(1,"busingss error");
        response.setMessage(ex.getMessage());
        return  response;

    }
}
