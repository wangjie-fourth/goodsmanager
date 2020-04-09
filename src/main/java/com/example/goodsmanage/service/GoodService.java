package com.example.goodsmanage.service;

import com.example.goodsmanage.domain.Good;

import java.util.List;
import java.util.Map;

public interface GoodService {
    List<Good> getExistGood();

    void addGood(Good good);

    void removeById(Long goodId);

    List<Good> selectAll();

    void editGoodById(Good good);
}
