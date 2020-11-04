package com.ly.commons.demos.java8;


import com.ly.commons.dto.OrderItemDTO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName LambdaDemo
 * @Author alan.wang   QQ:3103484396
 * @Description 语法糖
 */
public class LambdaDemo
{
    public static void sort(){
        List<OrderItemDTO> list = Arrays.asList(new OrderItemDTO("苹果" , new BigDecimal("50") , new BigDecimal("2")) ,
                                                new OrderItemDTO("香蕉" , new BigDecimal("40") , new BigDecimal("4")) ,
                                                new OrderItemDTO("橘子" , new BigDecimal("80") , new BigDecimal("4")) );
        /* 对list进行排序，按照单价从小到大排序 */
        /**
        Collections.sort(list, new Comparator<OrderItemDTO>() {
            @Override
            public int compare(OrderItemDTO o1, OrderItemDTO o2) {
                int o1Price = o1.getPrice().intValue();
                int o2Price = o2.getPrice().intValue();
                int result = 0;
                if(o1Price > o2Price){
                    return 1;
                } else if(o1Price == o2Price){
                    return 0;
                } else {
                    return -1;
                }
            }
        });
         */
        /* Lambda
        Collections.sort(list , (o1,o2)->{
            int o1Price = o1.getPrice().intValue();
            int o2Price = o2.getPrice().intValue();
            int result = 0;
            if(o1Price > o2Price){
                return 1;
            } else if(o1Price == o2Price){
                return 0;
            } else {
                return -1;
            }
        });
        */
        /* 函数指针
        Collections.sort(list , LambdaDemo::compare);
         */
        list.forEach(item->{
            System.out.println(item.getGoodsName());
        });
    }
    public static int compare(OrderItemDTO o1 , OrderItemDTO o2){
        int o1Price = o1.getPrice().intValue();
        int o2Price = o2.getPrice().intValue();
        int result = 0;
        if(o1Price > o2Price){
            return 1;
        } else if(o1Price == o2Price){
            return 0;
        } else {
            return -1;
        }
    }

    public static void threadDemo(){
        Thread t1 = new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------------" + System.currentTimeMillis());

            }
        });
        t1.start();
    }

    public static void main(String[] args)
    {
        sort();

    }
}