package com.msr.lesson04HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Test04Map {

    public static void main(String[] args) {
        // Map : 映射 : 键值对  :  键唯一,值可重复
        //      ${pageContext.request.contextPath}/UserServlet?username=tom&password=123

        // 名字和籍贯
        Map<String, String> map = new HashMap<>();
        // 增
        //  V put(K key, V value)
        //           将指定的值与此映射中的指定键关联（可选操作）。
        System.out.println(map.put("Tom","河南"));
        System.out.println(map.put("Tom","新疆"));
        map.put("Jerry","河南");
        map.put("Kitty","上海");
        map.put("LiSi","北京");
        map.put("XiaoMing","西安");
        // 删
        //  V remove(Object key)
        //           如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
        map.remove("Tom");
        //  void clear()
        //           从此映射中移除所有映射关系（可选操作）。
       // map.clear();
        // 判断
        //  boolean containsKey(Object key)
        //           如果此映射包含指定键的映射关系，则返回 true。
        System.out.println("map.containsKey(\"Kitty\") = " + map.containsKey("Kitty"));
        System.out.println("map.containsKey(\"King\") = " + map.containsKey("King"));

        //  boolean containsValue(Object value)
        //           如果此映射将一个或多个键映射到指定值，则返回 true。
        System.out.println("map.containsValue(\"北京\") = " + map.containsValue("北京"));
        System.out.println("map.containsValue(\"西藏\") = " + map.containsValue("西藏"));

        //  boolean isEmpty()
        //           如果此映射未包含键-值映射关系，则返回 true。
        System.out.println("map.isEmpty() = " + map.isEmpty());
        // 获取
        //  int size()
        //           返回此映射中的键-值映射关系数。
        System.out.println("map.size() = " + map.size());

        //  V get(Object key)
        //           返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
        System.out.println("map.get(\"XiaoMing\") = " + map.get("XiaoMing"));

        //  Set<K> keySet()
        //           返回此映射中包含的键的 Set 视图。
        Set<String> names = map.keySet();

        names.stream().forEach(name ->{
            System.out.println(name + " : " + map.get(name));
        });

        //  Collection<V> values()
        //           返回此映射中包含的值的 Collection 视图。
        Collection<String> values = map.values();
        values.stream().forEach(value -> System.out.println("value = " + value));

        System.out.println("--------22222222---------------");
        // Map的第二种遍历方式 : JDK1.8之前
        //  Set<Map.Entry<K,V>> entrySet()  :  一个键值对
        //           返回此映射中包含的映射关系的 Set 视图。
        Set<Map.Entry<String, String>> entries = map.entrySet();
        entries.stream().forEach(entry -> {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        });

        System.out.println("---------------------超级遍历方式---------------------");
        // JDK8.0遍历方式
        map.forEach((key , value) -> {
            System.out.println(key + " : " + value);
        });


        System.out.println(map);
    }
}
