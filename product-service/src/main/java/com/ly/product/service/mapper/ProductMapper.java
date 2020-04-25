package com.ly.product.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.commons.bo.product.ReduceProductStockBO;
import com.ly.product.service.entity.Product;

public interface ProductMapper extends BaseMapper<Product>
{
    public int reduceStock(ReduceProductStockBO map);
}
