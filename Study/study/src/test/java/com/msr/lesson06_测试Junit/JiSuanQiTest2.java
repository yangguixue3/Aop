package com.msr.lesson06_测试Junit;

import org.junit.*;

/**
 * @author 辉
 * @create 2020-12-10 11:12
 * @desc
 */
public class JiSuanQiTest2 {

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("BeforeClass");
    }
    @Before
    public void testBefore(){
        System.out.println("Before");
    }
    @AfterClass
    public static void testAfterClass(){
        System.out.println("AfterClass");
    }
    @After
    public void testAfter(){
        System.out.println("After");
    }

    @Test
    public void test1(){
        System.out.println("1111111111111111111");
    }

    @Test
    public void test2(){
        System.out.println("22222222222222");
    }

}
