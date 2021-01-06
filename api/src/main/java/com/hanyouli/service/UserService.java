package com.hanyouli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyouli.entity.User;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 14:07:16
 */
public interface UserService extends IService<User> {
    User login(User user);
}
