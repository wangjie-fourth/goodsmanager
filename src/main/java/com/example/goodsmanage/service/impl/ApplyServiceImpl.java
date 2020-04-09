package com.example.goodsmanage.service.impl;

import com.example.goodsmanage.domain.Good;
import com.example.goodsmanage.domain.GoodApply;
import com.example.goodsmanage.exception.InvalidParameterException;
import com.example.goodsmanage.mapper.GoodApplyMapper;
import com.example.goodsmanage.mapper.GoodMapper;
import com.example.goodsmanage.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName ApplyServiceImpl
 * @Description
 * @Author 25127
 * @Date 2020/4/2 22:12
 * @Email jie.wang13@hand-china.com
 **/
@Service
public class ApplyServiceImpl implements ApplyService {

    private final GoodApplyMapper goodApplyMapper;
    private final GoodMapper goodMapper;

    @Autowired
    public ApplyServiceImpl(GoodApplyMapper goodApplyMapper, GoodMapper goodMapper) {
        this.goodApplyMapper = goodApplyMapper;
        this.goodMapper = goodMapper;
    }

    @Override
    public List<GoodApply> selectAll() {
        return goodApplyMapper.selectAll();
    }

    @Override
    @Transactional
    public void add(GoodApply goodApply) {
        // 验证逻辑：当前领用数量不超过库存
        Good good = goodMapper.selectById(goodApply.getGoodId());
        if (good.getInventory() < goodApply.getApplyNumber()){
            throw new InvalidParameterException("领用数量超过库存数量");
        }
        good.setInventory(good.getInventory() - goodApply.getApplyNumber());
        goodMapper.updateById(good);
        goodApplyMapper.add(goodApply);
    }
}
