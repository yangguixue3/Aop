package com.msr.lesson15_枚举;


public class Season {

    private String name;
    private String desc;

    public static final Season SPRING = new Season("春天","春风又绿江南岸");
    public static final Season SUMMER = new Season("夏天","夏天日荷花别样红");
    public static final Season AUTUMN = new Season("秋天","秋水共长天一色");
    public static final Season WINTER = new Season("冬天","千里冰封,万里雪飘");


    private Season(String name, String desc) {
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
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
