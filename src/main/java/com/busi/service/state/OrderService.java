package com.busi.service.state;

/**
 * @author WangLei
 * on 2018/6/24
 */
public interface OrderService {

    /**
     *
     */
    void create();

    /**
     * sign agree
     * @param orderId
     * @param type
     */
    void signAgree(Long orderId,String type);

    /**
     * pay
     * @param orderId
     * @param type
     */
    void pay(Long orderId,String type);

}
