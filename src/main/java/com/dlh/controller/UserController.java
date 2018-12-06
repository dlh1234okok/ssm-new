package com.dlh.controller;

import com.github.pagehelper.PageInfo;
import com.dlh.base.BaseQuery;
import com.dlh.po.User;
import com.dlh.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private BaseQuery baseQuery;

    @RequestMapping("queryUser")
    @ResponseBody
    public User queryUser(Integer userId) throws Exception {
        return userService.queryById(userId);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Integer delete(Integer userId) throws Exception {
        return userService.delete(userId);
    }

    @RequestMapping("update")
    @ResponseBody
    public Integer update(User user) throws Exception {
        return userService.update(user);
    }

    @RequestMapping("insert")
    @ResponseBody
    public Integer insert(User user) throws Exception {
        return userService.insert(user);
    }

    @RequestMapping("page")
    @ResponseBody
    public List<User> page(@RequestParam(defaultValue = "1") Integer pageNum,
                     @RequestParam(defaultValue = "2") Integer pageSize) throws Exception {

        baseQuery.setPageNum(pageNum);
        baseQuery.setPageSize(pageSize);
        PageInfo<User> pageInfo = userService.queryForPage(baseQuery);
        List<User> users =  pageInfo.getList();
        return users;
    }

    @RequestMapping(value = "queryUser2/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public User queryUser2(@PathVariable Integer userId) throws Exception {
        return userService.queryById(userId);
    }
}
