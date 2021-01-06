package com.hanyouli.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyouli.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * (Goods)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-30 14:07:14
 */
@Service
public interface GoodsDao extends BaseMapper<Goods> {
    Page<Goods> selectGoodsList(@Param("ew")QueryWrapper queryWrapper,Page page);
}
