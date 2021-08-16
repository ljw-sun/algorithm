package net.ljw.基础算法.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LIJW
 * @date 2021/8/10 10:15 下午
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：lleer
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class leetCode14 {

    //利用26字母
    public int firstUniqChar(String s) {
        int count[] = new int[26];
        char[] chars = s.toCharArray();
        //统计每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            count[chars[i] - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[chars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    //利用map集合
    public int firstUniqChar01(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        //先统计每个字符的数量
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < s.length(); i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    //使用Java  API
    public int firstUniqChar03(String s) {
        for (int i = 0; i < s.length(); i++)
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        return -1;
    }

    public static void main(String[] args) {

        leetCode14 leetCode14 = new leetCode14();
        int i = leetCode14.firstUniqChar01("loveleetcode");
        int a = leetCode14.firstUniqChar("loveleetcode");
        int b = leetCode14.firstUniqChar03("loveleetcode");
        System.out.println(i);
        System.out.println(a);
        System.out.println(b);
    }
}

