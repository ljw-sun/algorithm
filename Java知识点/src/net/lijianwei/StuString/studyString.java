package net.lijianwei.StuString;

/**
 * @author LIJW
 * @date 2021/8/16 6:53 下午
 * 判断字符串中是否包含某个字符串
 * indexOf startsWith contains 用法
 */
public class studyString {


    //使用indexOf
    public void stringIndexOf(){
        String str1 = "abcdefg";
        int result1 = str1.indexOf("ab");
        System.out.println(result1);   //如果包含返回0
        if(result1 != -1){
            System.out.println("字符串str中包含子串“ab”"+result1);
        }else{
            System.out.println("字符串str中不包含子串“ab”"+result1);
        }
    }

    /**
     *     startsWith() 两种用法
     *     第一种：startsWith(String str,int index)   str要找的字符串 index要从字符串那个下标开始寻找
     *     第二种：startsWith(String str) str要找的字符串 默认找开头
     */
    public void stringStarsWith(){
        String s = "lijianwei";
        boolean wei = s.startsWith("wei"); //false
        boolean l = s.startsWith("l");//true
        boolean i = s.startsWith("i");//false
        System.out.println(i);
        System.out.println(l);
        System.out.println(wei);
        boolean i1 = s.startsWith("i", 1);//true
        System.out.println(i1);
    }

    /**
     * contains方法  可以直接用于判断是否包含所指字符串
     */
    public void stringContains(){
        String s = "lijianwei";
        boolean jian = s.contains("ai"); //false
        boolean jie = s.contains("ia"); //true
        System.out.println(jie);
        System.out.println(jian);
    }


    public static void main(String[] args) {
        studyString studyString = new studyString();
        studyString.stringIndexOf();
        studyString.stringStarsWith();
        studyString.stringContains();
    }

}
