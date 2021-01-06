package com.hanyouli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanyouli.dao.GoodsDao;
import com.hanyouli.entity.Goods;
import com.hanyouli.service.GoodsService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;


/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 14:07:28
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, Goods> implements GoodsService {

    @Resource
    private  GoodsDao goodsDao;

    @Override
    public Page selectGoodsList(Page page, String name, String min, String max) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("g.name",name);
        }
        if(!min.equals("")){
            queryWrapper.lt("price",min);
        }
        if(!max.equals("")){
            queryWrapper.gt("price",max);
        }
        Page<Goods> goodsPage = goodsDao.selectGoodsList(queryWrapper, page);
        return goodsPage;
    }
}
