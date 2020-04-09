package com.example.goodsmanage.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName Category
 * @Description
 * @Author 25127
 * @Date 2020/4/1 20:41
 * @Email jie.wang13@hand-china.com
 **/
@Data
@Builder
public class Category {
    private Long categoryId;
    private String categoryName;
}
