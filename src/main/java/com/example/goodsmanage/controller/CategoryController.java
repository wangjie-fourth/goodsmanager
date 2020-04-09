package com.example.goodsmanage.controller;

import com.example.goodsmanage.domain.Category;
import com.example.goodsmanage.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName CategoryController
 * @Description
 * @Author 25127
 * @Date 2020/4/4 1:21
 * @Email jie.wang13@hand-china.com
 **/
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public Object[] getCategoryList() {
        List<Category> categoryList = categoryService.selectAll();
        return categoryList.stream().map(i -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i.getCategoryId());
            map.put("text", i.getCategoryName());
            return map;
        }).toArray();
    }
}
