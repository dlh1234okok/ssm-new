package com.dlh.base;

import com.dlh.exception.ParamException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class ExceptionController {
    @ExceptionHandler
    public String ex(HttpServletRequest request,
                     Exception e){
        request.setAttribute("ex",e);
        if (e instanceof ParamException){
            return "param";
        }
        return "error";
    }
}
