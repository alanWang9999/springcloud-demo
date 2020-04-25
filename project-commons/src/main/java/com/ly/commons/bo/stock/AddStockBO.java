package com.ly.commons.bo.stock;

import java.math.BigDecimal;

/**
 * @ClassName AddStockBO
 * @Author alan.wang   QQ:3103484396
 * @Description 添加库存的BO
 */
public class AddStockBO
{
    /* 增加的商品id */
    private Integer id;
    /* 增加的库存量 */
    private BigDecimal qty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}
