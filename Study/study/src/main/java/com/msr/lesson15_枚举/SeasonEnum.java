package com.msr.lesson15_枚举;

public enum SeasonEnum {

    // 对象必须在第一条语句的位置
    SPRING("春天1","春风又绿江南岸"),
    SUMMER("春天2","春风又绿江南岸"),
    AUTUMN("春天3","春风又绿江南岸"),
    WINTER("春天4","春风又绿江南岸");

    private String name;
    private String desc;

    //  枚举类中构造器默认为私有的.
    SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
