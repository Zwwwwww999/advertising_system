package com.alone.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName AdPlanRequest
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/25 20:33
 * @Description AdPlanRequest
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanResponse implements Serializable {

    private Long id;
    private String planName;
}
