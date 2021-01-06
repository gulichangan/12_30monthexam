package com.hanyouli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyouli.entity.Mybuy;
import com.hanyouli.service.MybuyService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Mybuy)表控制层
 *
 * @author makejava
 * @since 2020-12-30 14:07:38
 */
@RestController
@RequestMapping("mybuy")
public class MybuyController extends ApiController {
    /**
     * 服务对象
     */
    @Reference(url = "localhost:20880")
    private MybuyService mybuyService;

    @RequestMapping("/toBuy")
    public boolean toBuy(@RequestBody Mybuy mybuy){
        boolean b = mybuyService.toBuy(mybuy);
        return b;
    }

    @RequestMapping("/list/{uid}")
    public List list(@PathVariable Integer uid){
        List list = mybuyService.listByUid(uid);
        return list;
    }
}
