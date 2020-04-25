package com.ly.commons.bo.sale;

import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ClassName AddSaleBO
 * @Author alan.wang   QQ:3103484396
 * @Description
 */
@ToString
public class AddSaleBO
{
    private Integer productid;
    private BigDecimal price;
    private Integer quantity;//销售数量
    private Integer userid;//销售员id

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
