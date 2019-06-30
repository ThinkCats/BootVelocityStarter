package com.busi.service.threadlocal.dto;

/**
 * @author WangLei
 * on 2019/6/28
 */

public class ParamHolder {
    private static ThreadLocal<ParamContext> param = ThreadLocal.withInitial(ParamContext::new);

    /**
     * 初始化订单信息
     *
     * @param orderNo
     */
    public static void initParam(String orderNo) {
        ParamContext paramContext = param.get();
        if (paramContext == null) {
            paramContext = new ParamContext();
            param.set(paramContext);
        }
        paramContext.setOrderNo(orderNo);
    }


    /**
     * 清除当前的订单信息
     */
    public static void clearOrder() {
        param.set(null);
    }

    public static ParamContext getContext() {
        return param.get();
    }


    public static void setProduct(ProductDTO product) {
        param.get().setProductDTO(product);
    }

    public static void setOrder(OrderDTO order) {
        param.get().setOrderDTO(order);
    }

    public static ProductDTO getProduct() {
        return param.get().getProductDTO();
    }

    public static String getOrderNO() {
        return param.get().getOrderNo();
    }
}
