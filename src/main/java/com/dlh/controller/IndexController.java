package com.dlh.controller;

import com.dlh.base.ExceptionController;
import com.dlh.exception.ParamException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("index")
public class IndexController extends ExceptionController{
    /*参数异常*/
    @RequestMapping("test01")
    public String test01() {
        if (true){
            throw  new ParamException("参数异常");
        }
        return "index";
    }
}
