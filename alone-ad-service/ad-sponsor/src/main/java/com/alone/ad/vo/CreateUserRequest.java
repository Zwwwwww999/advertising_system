package com.alone.ad.vo;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName CreateUserRequest
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/25 19:20
 * @Description CreateUserRequest
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest  implements Serializable {

    private String userName;

    public boolean validate(){
       return StrUtil.isEmpty(userName);
    }
}
