package com.ly.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName OrderItemDTO
 * @Author alan.wang   QQ:3103484396
 * @Description 订单项
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDTO
{
    /* 商品名称 */
    private String goodsName;
    /* 购买的单价 */
    private BigDecimal price;
    /* 购买的数量 */
    private BigDecimal qty;
}
