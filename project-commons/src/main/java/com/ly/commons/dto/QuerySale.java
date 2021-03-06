package com.ly.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName QuerySale
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuerySale
{
    private Integer id;
    private BigDecimal price;
}
