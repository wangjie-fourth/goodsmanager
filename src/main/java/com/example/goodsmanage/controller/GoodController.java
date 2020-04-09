package com.example.goodsmanage.controller;

import com.example.goodsmanage.domain.Category;
import com.example.goodsmanage.domain.Good;
import com.example.goodsmanage.service.CategoryService;
import com.example.goodsmanage.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName GoodsController
 * @Description
 * @Author 25127
 * @Date 2020/4/1 12:34
 * @Email jie.wang13@hand-china.com
 **/
@RestController
@RequestMapping("/good")
@Slf4j
public class GoodController {

    private final GoodService goodService;


    @Autowired
    public GoodController(GoodService goodService) {
        this.goodService = goodService;

    }

    @PostMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        // 获取商品库存表得信息
        List<Good> goods = goodService.selectAll();
        result.put("data", goods);
        return result;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Good good) {
        goodService.addGood(good);
        return ResponseEntity.ok(good);
    }
    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Good good) {
        goodService.editGoodById(good);
        return ResponseEntity.ok(good);
    }
    @GetMapping("/exist")
    public Object[] getExistAllGood() {
        List<Good> existGood = goodService.getExistGood();
        return existGood.stream().map(i -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i.getGoodId());
            map.put("text", i.getGoodName());
            return map;
        }).toArray();
    }

    @PostMapping("/remove")
    public ResponseEntity<?> remove(@RequestBody Good good) {
        goodService.removeById(good.getGoodId());
        return ResponseEntity.ok(good);
    }

}
