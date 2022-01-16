package net.lijianwei.StuString;

/**
 * @author LIJW
 * @date 2021/8/16 9:58 下午
 * indexOf lastIndexOf   用法
 */
public class studyStringIndexOf {

    /**
     * public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     *
     * public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     *
     * int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     *
     * int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     */

    public void strIndexOf(){
          String s = "lijianwei";
        int p = s.indexOf("p");  //不存在返回-1
        int i = s.indexOf("i");  //存在返回下标
        System.out.println(i);
        System.out.println(p);

    }


    /**
     * public int lastIndexOf(int ch): 返回指定字符在此字符串中最后一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     *
     * public int lastIndexOf(int ch, int fromIndex): 返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索，如果此字符串中没有这样的字符，则返回 -1。
     *
     * public int lastIndexOf(String str): 返回指定子字符串在此字符串中最右边出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     *
     * public int lastIndexOf(String str, int fromIndex): 返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索，如果此字符串中没有这样的字符，则返回 -1。
     */
    public void stuLastIndexOf(){
        String s = "lijianwei";
        int w = s.lastIndexOf("i"); //输出i在字符串中最后出现的位置
        System.out.println(w);
    }


    public static void main(String[] args) {

        studyStringIndexOf studyStringIndexOf = new studyStringIndexOf();
        studyStringIndexOf.stuLastIndexOf();
        studyStringIndexOf.strIndexOf();
    }

}
