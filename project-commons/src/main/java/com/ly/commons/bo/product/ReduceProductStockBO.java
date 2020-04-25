package com.ly.commons.bo.product;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName ReduceProductStock
 * @Author alan.wang   QQ:3103484396
 * @Description 减库存的BO
 */
@Data
@ToString
public class ReduceProductStockBO
{
    /* 减库存的商品id */
    private Integer id;
    /* 减少的数量 */
    private Integer reduceCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReduceCount() {
        return reduceCount;
    }

    public void setReduceCount(Integer reduceCount) {
        this.reduceCount = reduceCount;
    }

}
