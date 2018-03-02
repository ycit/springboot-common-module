package com.vastio.controller;

import com.vastio.bean.base.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * controller 异常处理
 *
 * @author xlch
 * @Date 2018-03-02 14:59
 */
@ControllerAdvice(annotations = RestController.class)
public class RestControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestControllerAdvice.class);

    @ExceptionHandler
    @ResponseBody
    public ApiResponse generalError(Exception ex, HttpServletRequest request) {
        LOGGER.error("Error 500: {}, {}", ex.getMessage(), ex.getStackTrace()[0]);
        ex.printStackTrace();
        ApiResponse error = new ApiResponse();
        error.setCode(500);
        error.setMessage("服务器内部错误");
        return error;
    }

}
