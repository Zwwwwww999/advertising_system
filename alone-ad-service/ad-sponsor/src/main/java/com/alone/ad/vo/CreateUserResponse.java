package com.alone.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName CreateUserResponse
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/25 19:24
 * @Description CreateUserResponse
 * @Version 1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CreateUserResponse  implements Serializable {

    private Long userId;
    private String username;
    private String token;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;



}
