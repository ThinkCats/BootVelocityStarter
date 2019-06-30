package com.busi.service.threadlocal.dto;

import lombok.Data;

/**
 * @author WangLei
 * on 2019/6/28
 */
@Data
public class ParamContext {
    private String orderNo;
    private OrderDTO orderDTO;
    private ProductDTO productDTO;

    public void clear() {
        this.setOrderNo(null);
        this.setOrderDTO(null);
        this.setProductDTO(null);
    }
}
