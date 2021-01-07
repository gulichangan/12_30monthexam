package com.hanyouli.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanyouli.dao.TypeDao;
import com.hanyouli.entity.Type;
import com.hanyouli.service.TypeService;
import org.apache.dubbo.config.annotation.Service;
/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 14:07:29
 */
@Service
public class typeServiceImpl extends ServiceImpl<TypeDao, Type> implements TypeService {

}
