package com.ly.product.service.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Product
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@NoArgsConstructor  //自动添加一个无参数的构造方法
@AllArgsConstructor //自动添加一个带有所有属性作为参数的构造方法
@Data
public class Product
{
    private Integer id;
    private String productname;
    private Integer quantity;

    public static void main(String[] args) {
        Product p = new Product(1 , "苹果" , 10);
        new Product();
    }
}
