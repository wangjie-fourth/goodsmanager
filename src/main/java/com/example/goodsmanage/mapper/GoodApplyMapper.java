package com.example.goodsmanage.mapper;


import com.example.goodsmanage.domain.GoodApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodApplyMapper {
    List<GoodApply> selectAll();

    void add(GoodApply goodApply);
}
