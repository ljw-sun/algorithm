package net.lijianwei.StuMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LIJW
 * @date 2021/8/17 10:25 上午
 * getOrDefault()方法
 */
public class stuMapGetOrDefault {


    /**
     * getOrDefault()
     * 返回 key 相映射的的 value，如果给定的 key 在映射关系中找不到，则返回指定的默认值。
     */
    public void stuGetOrDefault(){
        Map<String,Integer> map = new HashMap<>();
        map.put("d",1);

        Integer d = map.getOrDefault("d", 0);  //map中存在，返回value
        Integer i = map.getOrDefault("i", 0);  //map中不存在，返回默认值0
        System.out.println(d);
        System.out.println(i);
    }


    public static void main(String[] args) {

        stuMapGetOrDefault stuMapGetOrDefault = new stuMapGetOrDefault();
        stuMapGetOrDefault.stuGetOrDefault();
    }
}
