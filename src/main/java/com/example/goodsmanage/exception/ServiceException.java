package com.example.goodsmanage.exception;

import lombok.Data;

/**
 * @ClassName ServiceException
 * @Description
 * @Author 25127
 * @Date 2020/3/18 14:48
 * @Email jie.wang13@hand-china.com
 **/
@Data
public class ServiceException extends RuntimeException {
    private int statusCode;
    private String errorCode;
    private ServiceException.ErrorType errorType;// Service、Client、Unknown

    public enum ErrorType {
        Client,
        Service,
        Unknown;
    }

    public ServiceException(String message) {
        super(message);
    }
}
