package com.example.hibernatevalidatortest.com.validation.exception;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: tiankuokuo
 * @description: 处理IllegalArgumentException异常
 * @date: 2018/10/18 13:46
 * @version: V1.0
 */
@ControllerAdvice(basePackages = "com.example.hibernatevalidatortest.com.controller")
public class IllegalArgumentExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    public Object runTimeException(HttpServletRequest request, IllegalArgumentException e) {
        String uri = request.getRequestURI();
        HashMap<String, Object> error = new HashMap<>(16);
        error.put("path", uri);
        error.put("exception", "非法参数");
        error.put("error", JSON.parse(e.getMessage()));
        return error;
    }
}
