package com.hanyouli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (Mybuy)表实体类
 *
 * @author makejava
 * @since 2020-12-30 14:07:15
 */
@SuppressWarnings("serial")
public class Mybuy extends Model<Mybuy> {

    @TableId(type =  IdType.AUTO)
    private Integer id;

    private Integer code;

    private String gname;

    private Integer num;

    private Integer price;

    private Date toGetTime;

    private Integer payPrice;

    private Integer payScore;

    private Integer sendCode;

    private Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getToGetTime() {
        return toGetTime;
    }

    public void setToGetTime(Date toGetTime) {
        this.toGetTime = toGetTime;
    }

    public Integer getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Integer payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getPayScore() {
        return payScore;
    }

    public void setPayScore(Integer payScore) {
        this.payScore = payScore;
    }

    public Integer getSendCode() {
        return sendCode;
    }

    public void setSendCode(Integer sendCode) {
        this.sendCode = sendCode;
    }

    @Override
    public String toString() {
        return "Mybuy{" +
                "id=" + id +
                ", code=" + code +
                ", gname='" + gname + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", toGetTime=" + toGetTime +
                ", payPrice=" + payPrice +
                ", payScore=" + payScore +
                ", sendCode=" + sendCode +
                ", uid=" + uid +
                '}';
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
