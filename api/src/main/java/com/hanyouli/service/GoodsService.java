package com.hanyouli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hanyouli.entity.Goods;

/**
 * (Goods)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 14:07:15
 */
public interface GoodsService extends IService<Goods> {
    Page selectGoodsList(Page page,String name,String min,String max);
}
