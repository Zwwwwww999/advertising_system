package com.alone.ad.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 忽略统一响应标识注解
 * @ClassName IgnoreResponseAdvice
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/21 19:51
 * @Description IgnoreResponseAdvice
 * @Version 1.0
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
