package com.ly.sale.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.ly.sale.service.entity.Sale;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.LruCache;

public interface SaleMapper extends BaseMapper<Sale>
{
}
