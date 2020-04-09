package com.example.goodsmanage.service;

import com.example.goodsmanage.domain.GoodApply;

import java.util.List;

public interface ApplyService {
    List<GoodApply> selectAll();

    void add(GoodApply goodApply);
}
