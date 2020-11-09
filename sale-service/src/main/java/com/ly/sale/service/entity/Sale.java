package com.ly.sale.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.LruCache;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Sale
 * @Author alan.wang   QQ:3103484396
 * @Description 销售的实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale implements Serializable
{
    @TableId(type = IdType.AUTO)
    private Integer id;//销售单号
    private BigDecimal price;//单价
    private Integer quantity;//销售数量
    private BigDecimal totalprice;//总价格
    private Date saledate;//销售日期
    private Integer userid;//销售员id
    private Integer productid;//销售的商品id
}
