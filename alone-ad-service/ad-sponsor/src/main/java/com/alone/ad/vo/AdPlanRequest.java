package com.alone.ad.vo;

import cn.hutool.core.util.StrUtil;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdPlanRequest implements Serializable {

    private Long id;
    private Long userId;
    private String planName;
    private String startDate;
    private String endDate;

    public boolean createValidate() {

        return userId != null
                && !StrUtil.isEmpty(planName)
                && !StrUtil.isEmpty(startDate)
                && !StrUtil.isEmpty(endDate);
    }

    public boolean updateValidate() {

        return id != null && userId != null;
    }

    public boolean deleteValidate() {

        return id != null && userId != null;
    }
}
