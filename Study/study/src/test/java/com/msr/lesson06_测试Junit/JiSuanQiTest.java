package com.msr.lesson06_测试Junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 */
public class JiSuanQiTest {

    @Test
    public void testAdd(){
        Assert.assertEquals(20,new JiSuanQi().add(10,10));
    }

    @Test
    public void testJian(){
        Assert.assertEquals(0,new JiSuanQi().jian(10,10));
    }

    @Ignore
    @Test
    public void testCheng(){
        Assert.assertEquals(100,new JiSuanQi().cheng(10,10));
    }

    @Test(expected = ArithmeticException.class)
    public void testDiv(){
        Assert.assertEquals(1,new JiSuanQi().div(10,0));
    }

    @Test(timeout = 2000)
    public void testRun(){
        try {
            Thread.sleep(2001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
