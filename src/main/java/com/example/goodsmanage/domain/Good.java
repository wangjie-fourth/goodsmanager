package com.example.goodsmanage.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName Good
 * @Description
 * @Author 25127
 * @Date 2020/4/1 20:39
 * @Email jie.wang13@hand-china.com
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private Long goodId;
    private String goodName;
    private Long categoryId;
    private Date storageDate;
    private String unit;
    private Long inventory;
    private String note;

    //==========================
    private Category category;
}
