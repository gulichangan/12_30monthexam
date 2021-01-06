package com.hanyouli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyouli.entity.User;
import com.hanyouli.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-12-30 14:07:38
 */
@RestController
@RequestMapping("user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Reference(url = "localhost:20880")
    private UserService userService;

    @RequestMapping("/login")
    public User login(@RequestBody User user){
        User login = userService.login(user);
        if(login!=null){
            return login;
        }
        return null;
    }
}
