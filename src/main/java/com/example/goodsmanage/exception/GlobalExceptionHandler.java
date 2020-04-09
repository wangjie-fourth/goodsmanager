package com.example.goodsmanage.exception;

import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理：解决Controller有过多的错误处理代码
 * @Author 25127
 * @Date 2020/3/18 15:12
 * @Email jie.wang13@hand-china.com
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    ResponseEntity<?> handleServiceException(ServiceException ex) {
        val errorResponse = ErrorResponse.builder()
                .code(ex.getErrorCode())
                .statusCode(ex.getStatusCode())
                .errorType(ex.getErrorType())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
    }

    // ------- 非本服务自定义异常的单独处理 ----------


}
