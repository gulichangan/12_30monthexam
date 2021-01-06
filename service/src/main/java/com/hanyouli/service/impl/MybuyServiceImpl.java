package com.hanyouli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanyouli.dao.MybuyDao;
import com.hanyouli.entity.Goods;
import com.hanyouli.entity.Mybuy;
import com.hanyouli.entity.User;
import com.hanyouli.mq.Provider;
import com.hanyouli.service.GoodsService;
import com.hanyouli.service.MybuyService;
import com.hanyouli.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Mybuy)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 14:07:29
 */
@Service
public class MybuyServiceImpl extends ServiceImpl<MybuyDao, Mybuy> implements MybuyService {

    @Resource
    private UserService userService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private Provider provider;

    Logger logger = LoggerFactory.getLogger(MybuyServiceImpl.class);

    @Override
    public boolean toBuy(Mybuy mybuy) {
        User user = userService.getById(mybuy.getUid());
        if(user != null && user.getMoney() > mybuy.getPayPrice()){
            mybuy.setToGetTime(new Date());
            boolean save = this.save(mybuy);
            if(save){
                System.out.println(mybuy);
                QueryWrapper queryWrapper = new QueryWrapper();
                queryWrapper.eq("id",mybuy.getId());
                Mybuy one = this.getOne(queryWrapper);
                Integer code = one.getId();
                mybuy.setCode(code);
                this.updateById(mybuy);
                user.setMoney(user.getMoney() - one.getPayPrice());
                if(one.getCode() != null){
                    user.setScore(user.getScore() - one.getPayScore() + (int)(one.getPayPrice() /10));
                }
                userService.updateById(user);
                if(mybuy.getSendCode() != null){
                    Goods goods = goodsService.getById(one.getSendCode());
                    Mybuy send = new Mybuy();
                    send.setGname(goods.getName());
                    send.setCode(code);
                    send.setNum(1);
                    send.setPayPrice(0);
                    send.setPayScore(0);
                    send.setPrice(goods.getPrice());
                    send.setUid(mybuy.getUid());
                    send.setToGetTime(mybuy.getToGetTime());
                    boolean save1 = this.save(send);
                    provider.send(mybuy.getGname());
                    logger.info("生产者发出消息");
                    return save1;
                }
            }
        }
        return false;
    }

    @Override
    public List listByUid(Integer uid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",uid);
        return this.list(queryWrapper);
    }
}
