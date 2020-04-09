package com.example.goodsmanage.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName ErrorResponse
 * @Description
 * @Author 25127
 * @Date 2020/3/18 15:02
 * @Email jie.wang13@hand-china.com
 **/
@Data
@Builder
public class ErrorResponse {
    private String code;
    private ServiceException.ErrorType errorType;
    private String message;
    private int statusCode;
}
