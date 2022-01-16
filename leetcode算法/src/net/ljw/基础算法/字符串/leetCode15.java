package net.ljw.基础算法.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LIJW
 * @date 2021/8/17 2:34 下午
 *   有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t仅包含小写字母
 * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class leetCode15 {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        boolean isNoYes = true;
        for (int i = 0; i < chars.length; i++) {
            Integer sum = 0;
            for (int i1 = 0; i1 < chars.length; i1++) {
                if (chars[i] == chars[i1]){
                    sum++;
                }
               map1.put(chars[i],sum);
            }
        }
        System.out.println(map1);

        for (int i = 0; i < chars1.length; i++) {
            Integer sum = 0;
            for (int i1 = 0; i1 < chars1.length; i1++) {
                if (chars1[i] == chars1[i1]){
                    sum++;
                }

            }
            Integer integer = map1.get(chars1[i]);
            if (integer != sum){
                isNoYes = false;
            }
           map1.remove(chars1[i]);
        }

        if (map1.size() != 0){
            isNoYes = false;
        }
        return isNoYes;
    }

    public static void main(String[] args) {
        System.out.println(new leetCode15().isAnagram("abc","bac"));
    }
}
