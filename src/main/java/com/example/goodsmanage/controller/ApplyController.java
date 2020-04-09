package com.example.goodsmanage.controller;

import com.example.goodsmanage.domain.GoodApply;
import com.example.goodsmanage.service.ApplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ApplyController
 * @Description
 * @Author 25127
 * @Date 2020/4/1 15:49
 * @Email jie.wang13@hand-china.com
 **/
@RestController
@RequestMapping("/apply")
@Slf4j
public class ApplyController {
    private final ApplyService applyService;

    @Autowired
    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;

    }

    @PostMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        List<GoodApply> goodApplyList = applyService.selectAll();
        result.put("data", goodApplyList);
        return result;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody GoodApply goodApply) {
        applyService.add(goodApply);
        return ResponseEntity.ok(goodApply);
    }
}
