package com.example.snow.utils;


import com.baomidou.mybatisplus.core.toolkit.Sequence;

import java.net.InetAddress;

/**
 * mybatis plus 实现雪花算法
 * @author wxz
 * @date 20:55 2022/10/22
 */
public class SnowFlakeUtils {

    /**
     * 核心实现
     */
    private final Sequence sequence;

    /**
     *
     * @author wxz
     * @date 21:05 2022/10/22
     */
    public SnowFlakeUtils() {
        this.sequence = new Sequence(null);
    }

    /**
     *
     * @author wxz
     * @date 21:05 2022/10/22
     */
    public SnowFlakeUtils(InetAddress inetAddress) {
        this.sequence = new Sequence(inetAddress);
    }

    /**
     *
     * @author wxz
     * @date 21:05 2022/10/22
     */
    public SnowFlakeUtils(long workerId, long dataCenterId) {
        this.sequence = new Sequence(workerId, dataCenterId);
    }

    /**
     *
     * @author wxz
     * @date 21:05 2022/10/22
     */
    public SnowFlakeUtils(Sequence sequence) {
        this.sequence = sequence;
    }

    /**
     * 生成主键ID 生成61位二进制数字（0和1）然后转成十进制
     * 长度 = 19的十进制数字
     * @author wxz
     * @date 21:02 2022/10/22 
     * @return java.lang.Long
     */
    public Long nextId() {
        return this.sequence.nextId();
    }

    /**
     *
     * @author wxz
     * @date 21:04 2022/10/22
     */
    public static void main(String[] args) {
        SnowFlakeUtils snowFlakeUtils = new SnowFlakeUtils();
        System.out.println(snowFlakeUtils.nextId());
    }

}
