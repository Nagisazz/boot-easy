package com.nagisazz.booteasy.controller;

import com.nagisazz.booteasy.base.result.Result;
import com.nagisazz.booteasy.base.vo.PageParam;
import com.nagisazz.booteasy.entity.User;
import com.nagisazz.booteasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NagisaZZ
 * @description: UserController
 * @date 2019/4/22  10:18
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findone")
    public Result findByName() {
        return Result.success(userService.findByName("aa"));
    }

    @RequestMapping("/findAll")
    public Result selectNamePage() {
        PageParam pageParam = new PageParam();
        pageParam.setPageNo(0);
        pageParam.setPageSize(10);
        return Result.success(userService.selectNamePage("aa", pageParam));
    }

    @RequestMapping("/insert")
    public Result insert() {
        User user = new User();
        user.setName("aa");
        user.setPassword("aa");
        userService.insert(user);
        return Result.success();
    }
}
