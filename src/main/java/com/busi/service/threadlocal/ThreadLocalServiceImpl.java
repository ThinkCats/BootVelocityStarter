package com.busi.service.threadlocal;

import com.busi.service.threadlocal.dto.ParamHolder;
import com.busi.service.threadlocal.dto.ProductDTO;
import org.springframework.stereotype.Service;

/**
 * @author WangLei
 * on 2019/6/28
 */
@Service
public class ThreadLocalServiceImpl implements ThreadLocalService {

    @Override
    public void doSomething(String userName, String productId, String orderNo) {
        //初始化信息
        ParamHolder.initParam(orderNo);

        //构造外部查询的金融产品
        queryAndSaveProduct(productId);

        //保存金融方案费用
        saveFeeInfo(orderNo);

        //清理参数信息
        ParamHolder.clearOrder();
    }

    private void saveFeeInfo(String orderNo) {
        log("Save Fee Info For OrderNo:" + orderNo);
        ProductDTO productDTO = ParamHolder.getProduct();
        String productName = productDTO.getName();
        //....
        log("Save Fee, Product Name,OrderNo:" + orderNo + ", Product Name:" + ParamHolder.getProduct().toString());
    }

    private void queryAndSaveProduct(String productId) {
        log("Query Product: " + productId);
        ProductDTO productDTO = new ProductDTO();
        String productName = "TestProduct_" + ParamHolder.getOrderNO();
        productDTO.setName(productName);
        ParamHolder.setProduct(productDTO);
    }

    private void log(String msg) {
        System.out.println("[" + Thread.currentThread().getName() + "] - " + msg);
    }
}
