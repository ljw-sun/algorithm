package net.lijianwei.StuMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author LIJW
 * @date 2021/8/17 2:27 下午
 * 循环map的4种方式
 */
public class stuFroMap {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        map.put("1","123");
        map.put("2","456");
        map.put("3","789");

        //第一种 使用KeySet
        for (String key : map.keySet()) {
            System.out.println(key+":"+map.get(key));
        }


        //第二种 使用Iterator   entrySet()
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> stringEntry = iterator.next();
            System.out.println(stringEntry.getKey()+":"+stringEntry.getValue());
        }

        //第三种   entrySet()

        for (Map.Entry<String,String> stringEntry : map.entrySet()) {
            System.out.println(stringEntry.getKey()+":"+stringEntry.getValue());
        }


        //第四种 只能显示出值
        for (String m : map.values()) {
            System.out.println(m);
        }

    }
}
