package com.example.goodsmanage.exception;

import org.springframework.http.HttpStatus;

/**
 * @ClassName InvalidParameterException
 * @Description
 * @Author 25127
 * @Date 2020/3/18 15:23
 * @Email jie.wang13@hand-china.com
 **/
public class InvalidParameterException extends ServiceException {
    public InvalidParameterException(String message) {
        super(message);
        this.setStatusCode(HttpStatus.BAD_REQUEST.value());
        this.setErrorCode("INVALID_PARAMETER");
        this.setErrorType(ErrorType.Client);
    }
}
