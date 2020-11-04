package com.ly.commons.demos.java8;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName FunctionalDemo
 * @Author alan.wang   QQ:3103484396
 * @Description 函数指针
 */
public class FunctionalDemo
{
    public String flag = "8082";


    public void execute(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("execute方法执行中" + System.currentTimeMillis());
        }
    }

    public static void testFunctional(Runnable runnable){
        System.out.println("入参的类型:" + runnable.getClass());
        try {
            Field field = runnable.getClass().getDeclaredField("arg$1");
            field.setAccessible(true);
            Object object1 = field.get(runnable);
            Field flatField = object1.getClass().getDeclaredField("flag");
            flatField.setAccessible(true);
            String flag = (String) flatField.get(object1);
            System.out.println("flat:" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        runnable.run();
    }


    public static void main(String[] args) {
        /* 这种写法是语法糖，真正在执行的时候，Thread接收到的还是一个对象 */
        FunctionalDemo functionalDemo = new FunctionalDemo();
        testFunctional(functionalDemo::execute);
    }
}
