package com.alone.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/21 19:43
 * @Description Result
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public  Result(Integer code, String message){
            this.code = code;
            this.message = message;
    }


}
