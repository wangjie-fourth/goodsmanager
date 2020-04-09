package com.example.goodsmanage.service.impl;

import com.example.goodsmanage.domain.Category;
import com.example.goodsmanage.mapper.CategoryMapper;
import com.example.goodsmanage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description
 * @Author 25127
 * @Date 2020/4/2 22:48
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }
}
