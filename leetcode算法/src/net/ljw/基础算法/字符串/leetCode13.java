package net.ljw.基础算法.字符串;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LIJW
 * @date 2021/8/10 6:24 下午
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 * -231 <= x <= 231 - 1
 *
 */
public class leetCode13 {
    //自己的方法
    public int reverse(int x) {
        int sum = 0;
        while (x != 0 ){
            int i = x % 10;
             x = x / 10;
            sum = sum * 10 + i;
        }
        if (sum  > Integer.MAX_VALUE && sum < Integer.MIN_VALUE){
            return 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        leetCode13 leetCode13 = new leetCode13();
        int reverse = leetCode13.reverse(-1238);
        System.out.println(reverse);
    }
}
