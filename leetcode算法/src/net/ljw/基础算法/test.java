package net.ljw.基础算法;

import java.util.Arrays;

/**
 * @author LIJW
 * @date 2021/9/24 8:30 下午
 */
public class test {

    public static String yesNoWord(String word1,String word2){
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        char[] chars = new char[word2.length()];
        int p = 0;

        for (int i = 0; i < chars2.length; i++) {
            for (int j = p; j < chars1.length; j++) {
                if (chars2[i] == chars1[j]){
                    chars[i] = chars1[j];
                    p = j;
                    break;
                }
            }
        }
        boolean s = Arrays.equals(chars2, chars);
        if(s){
            return "yes";
        }
        return "no";
    }


    public static void main(String[] args) {
        System.out.println(yesNoWord("abcde", "bce"));
        System.out.println(yesNoWord("abcde", "ed"));

    }

}
