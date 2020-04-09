package com.example.goodsmanage.service.impl;

import com.example.goodsmanage.domain.Category;
import com.example.goodsmanage.domain.Good;
import com.example.goodsmanage.exception.InvalidParameterException;
import com.example.goodsmanage.mapper.GoodMapper;
import com.example.goodsmanage.service.CategoryService;
import com.example.goodsmanage.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName GoodsServiceImpl
 * @Description
 * @Author 25127
 * @Date 2020/4/1 20:37
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class GoodServiceImpl implements GoodService {
    private final GoodMapper goodMapper;
    private final CategoryService categoryService;

    @Autowired
    public GoodServiceImpl(GoodMapper goodMapper, CategoryService categoryService) {
        this.goodMapper = goodMapper;
        this.categoryService = categoryService;
    }

    @Override
    public List<Good> getExistGood() {
        return goodMapper.getExistGood();
    }

    @Override
    public void addGood(Good good) {
        // 验证逻辑：物品名称不能重复
        Good hasGoodName = goodMapper.selectByGoodName(good.getGoodName());
        if (Objects.nonNull(hasGoodName)){
            throw new InvalidParameterException("物品名称重复！");
        }
        // 向数据添加数据
        goodMapper.insert(good);
    }



    @Override
    public void removeById(Long goodId) {
        goodMapper.removeById(goodId);
    }

    @Override
    public List<Good> selectAll() {
        return goodMapper.selectAll();
    }

    @Override
    public void editGoodById(Good good) {
        goodMapper.updateById(good);
    }
}
