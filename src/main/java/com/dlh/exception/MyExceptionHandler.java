package com.dlh.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        System.out.println("=============================");
        System.out.println("======MyExceptionHandler=====");
        System.out.println("=============================");
        ModelAndView mv = new ModelAndView();
        if (ex instanceof ParamException){
            ParamException paramException = (ParamException) ex;
            mv.setViewName("param");
            mv.addObject("ex",ex);
            return mv;
        }
        mv.setViewName("error");
        mv.addObject("ex",ex);
        return mv;
    }
}
