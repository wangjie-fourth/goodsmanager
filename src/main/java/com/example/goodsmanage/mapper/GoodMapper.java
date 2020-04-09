package com.example.goodsmanage.mapper;

import com.example.goodsmanage.domain.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodMapper {
    List<Good> getExistGood();

    Good selectById(@Param("goodId") Long goodId);

    Good selectByGoodName(@Param("goodName") String goodName);

    void insert(Good good);

    void removeById(@Param("goodId") Long goodId);

    List<Good> selectAll();

    void updateById(Good good);
}
