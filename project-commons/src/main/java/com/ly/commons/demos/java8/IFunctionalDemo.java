package com.ly.commons.demos.java8;

/**
 *  只规定一个抽象方法的接口，称作函数式接口
 *  java8中的接口，可以写静态方法、默认方法
 *  @author alan.wang   QQ:3103484396
 *  @return
 */
public interface IFunctionalDemo
{
    public String exec(int day);

    default void defaultMethod(){
        System.out.println("接口中的默认方法");
    }

    public static void staticMethod(){
        System.out.println("接口中的默认方法");
    }
}
