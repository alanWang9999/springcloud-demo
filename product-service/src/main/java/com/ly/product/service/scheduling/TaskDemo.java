package com.ly.product.service.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName TaskDemo
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@Component
public class TaskDemo
{
    @Scheduled(fixedRate = 3000) //fixedRate按照固定时间间隔执行此方法
    public void task1(){
        System.out.println("task1----------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(fixedDelay = 3000)//fixedDelay按照固定时间间隔，延迟执行
    public void task2(){
        System.out.println("task2----------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     *  cron:是一种表达式，是quartz框架中的表达式，组成
     *  秒 分 时 日 月 星期 年
     *  规则如下:
     *  1.  *表示任意所有
     *  2.  年可以忽略，忽略就表示任意一年
     *  3.  可以利用/来指定循环间隔---> 从几开始/间隔时间
     *  4.  日和星期两个字段冲突，只能使用其中一个，另一个字段使用?,使用问号表示字段被忽略
     *  5.  L可以用在日和星期中，用在日中，表示月的最后一天，用在星期中，表示月的最后一个星期，例如：星期字段使用2L表示月的最后一周的周二
     *  6.  #在星期字段中使用，表示月第几周的周几执行  例如  3#1  表示月的第三个星期的星期一执行
     *  @author alan.wang   QQ:3103484396
     *  @return
     */
    @Scheduled(cron = "0/3 * * ? * 1")
    public void task3(){
        System.out.println("--------------task3--------------");
    }
}
