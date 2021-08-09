package net.ljw.基础算法.数组;

import java.util.Arrays;

/**
 * @author LIJW
 * @date 2021/7/30 6:46 下午
 * 题目缩写：加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * 示例2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 */
public class leetCode07 {


    //自己的写发 错误，没有考虑个位之外的其它位
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] = digits[i]+1;
        return digits;
    }

    //网上参考
    public int[] plusOne2(int[] digits) {

        for (int i = digits.length - 1 ; i >= 0; i--) {

            if (digits[i] != 9){
                //如果不为9直接加一返回  因为是9+1要进
                digits[i]++;
                return digits;
            }else {
                //如果为0直接为0 再次循环到上一位加1
                digits[i] = 0;
            }
        }
        //如果全为9则，需要扩充数组
        int[] ints = new int[digits.length+1];
        //其它位不用管默认数组为0
        ints[0] = 1;
        return ints;
    }


    public static void main(String[] args) {

        leetCode07 leetCode07 = new leetCode07();
        int[] ints = leetCode07.plusOne2(new int[]{4,3,9,9});
        int[] ints1 = leetCode07.plusOne2(new int[]{9,9,9,9});
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
    }
}
