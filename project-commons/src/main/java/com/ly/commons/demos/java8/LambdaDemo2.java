package com.ly.commons.demos.java8;

/**
 * @ClassName LambdaDemo2
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
public class LambdaDemo2
{
    int i = 0;

    public static void main(String[] args)
    {
        IFunctionalDemo functionalDemo = new IFunctionalDemo() {
            @Override
            public String exec(int day) {
                return "大家好!!!!!!!今天是星期:"+day;
            }
        };
        IFunctionalDemo functionalDemo1 = (day)-> "大家好!!!!!!!今天是星期:"+day;

        System.out.println(functionalDemo1.exec(2));
    }
}

