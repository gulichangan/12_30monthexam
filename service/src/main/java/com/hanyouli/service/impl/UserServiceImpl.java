package com.hanyouli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanyouli.dao.UserDao;
import com.hanyouli.entity.User;
import com.hanyouli.service.UserService;
import org.apache.dubbo.config.annotation.Service;
/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 14:07:29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public User login(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",user.getName());
        queryWrapper.eq("password",user.getPassword());
        User one = this.getOne(queryWrapper);
        return one;
    }
}
