package com.hanyouli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyouli.entity.Mybuy;

import java.util.List;

/**
 * (Mybuy)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 14:07:16
 */
public interface MybuyService extends IService<Mybuy> {
    boolean toBuy(Mybuy mybuy);
    List listByUid(Integer uid);
}
