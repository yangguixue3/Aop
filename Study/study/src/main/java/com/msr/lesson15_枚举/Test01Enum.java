package com.msr.lesson15_枚举;


public class Test01Enum {

    public static void main(String[] args) {
        // 枚举 : enum : 一个类的对象是有限个并且是固定的.
        // 本质是一个特殊的类
        // Season season = new Season();
        System.out.println(Season.AUTUMN);
        // SeasonEnum seasonEnum = new SeasonEnum();

        // 获取所有枚举对象所在的数组
        SeasonEnum[] values = SeasonEnum.values();
        // 遍历
        for (int i = 0; i < values.length; i++) {
            System.out.println("values = " + values[i]);
        }

        System.out.println(SeasonEnum.AUTUMN);


        System.out.println("SeasonEnum.valueOf(\"SPRING\") = " + SeasonEnum.valueOf("SPRING"));
        System.out.println("SeasonEnum.valueOf(\"SPRING\") = " + SeasonEnum.valueOf("SUMMER"));
    }
}
