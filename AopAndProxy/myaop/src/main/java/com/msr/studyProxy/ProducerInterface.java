package com.msr.studyProxy;

public interface ProducerInterface {
    /**
     * 销售
     * @param money
     */
    void saleProduct(Double money);

    /**
     * 售后
     * @param money
     */
    void afterService(Double money);
}
