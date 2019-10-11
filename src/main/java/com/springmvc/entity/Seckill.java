package com.springmvc.entity;

import java.util.Date;

public class Seckill {
    /**
     * 商品库存id
	 * create by qmf on 2019-10-11T15:50:29.182
     */
    private Long seckillId;

    /**
     * 商品名称
	 * create by qmf on 2019-10-11T15:50:29.184
     */
    private String name;

    /**
     * 库存数量
	 * create by qmf on 2019-10-11T15:50:29.184
     */
    private Integer number;

    /**
     * 秒杀开始时间
	 * create by qmf on 2019-10-11T15:50:29.184
     */
    private Date startTime;

    /**
     * 秒杀结束时间
	 * create by qmf on 2019-10-11T15:50:29.185
     */
    private Date endTime;

    /**
     * 创建时间
	 * create by qmf on 2019-10-11T15:50:29.185
     */
    private Date createTime;

    /**
     * 商品库存id
     */
    public Long getSeckillId() {
        return seckillId;
    }

    /**
     * 商品库存id
     */
    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    /**
     * 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 库存数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 库存数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 秒杀开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 秒杀开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 秒杀结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 秒杀结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}