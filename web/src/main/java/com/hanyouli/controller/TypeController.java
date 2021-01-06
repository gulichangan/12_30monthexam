package com.hanyouli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanyouli.entity.Type;
import com.hanyouli.service.TypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2020-12-30 14:07:38
 */
@RestController
@RequestMapping("type")
public class TypeController extends ApiController {
    /**
     * 服务对象
     */
    @Reference(url = "localhost:20880")
    private TypeService typeService;

}
