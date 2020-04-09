package com.example.goodsmanage.mapper;

import com.example.goodsmanage.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    List<Category> selectAll();
}
