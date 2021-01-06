package com.hanyouli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyouli.entity.Goods;
import com.hanyouli.service.GoodsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Goods)表控制层
 *
 * @author makejava
 * @since 2020-12-30 14:07:37
 */
@RestController
@RequestMapping("goods")
public class GoodsController extends ApiController {
    /**
     * 服务对象
     */
    @Reference(url = "localhost:20880")
    private GoodsService goodsService;

    @RequestMapping("/list")
    public Page list(@RequestParam(defaultValue = "1")Integer current,
                     @RequestParam(defaultValue = "")String name,
                     @RequestParam(defaultValue = "")String min,
                     @RequestParam(defaultValue = "")String max){
        Page page = new Page(current,3);
        Page pageList = goodsService.selectGoodsList(page, name, min, max);
        return pageList;
    }

    @RequestMapping("/getOne/{id}")
    public Goods getOne(@PathVariable Integer id){
        Goods byId = goodsService.getById(id);
        return byId;
    }

}
