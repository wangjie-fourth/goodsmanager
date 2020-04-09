package com.example.goodsmanage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName GoodApply
 * @Description
 * @Author 25127
 * @Date 2020/4/1 20:41
 * @Email jie.wang13@hand-china.com
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodApply {
    private Long goodApplyId;
    private Long goodId;
    private String applyUser;
    private Date applyDate;
    private Integer applyNumber;
    private String applyExplain;

    // ============================
    private Good good;
}
