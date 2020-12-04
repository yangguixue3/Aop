package com.msr.studyProxy2;

/**
 * 厂家卖
 */
public class Producer  {
    /**
     * 场景:
     * 厂家卖货
     * 代理卖货，代理商要提成
     *

     *
     * @param money
     */
    public void saleProduct(Double money){
        System.out.println("厂家卖货获得····:"+money);
    }

    public void afterService(Double money) {
        System.out.println("厂家售后获得····:"+money);
    }
}
