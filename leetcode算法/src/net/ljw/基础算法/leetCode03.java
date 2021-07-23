package net.ljw.基础算法;

import java.util.Arrays;

/**
 * @author LIJW
 * @date 2021/7/23 10:09 上午
 * 旋转数组
 *
 *
 * 给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 *             0 + 1 1
 *             1 + 1 2
 *             2 + 1 3
 *             3 + 1 4
 *             4 + 1 5
 *             5 + 1 6
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class leetCode03 {

    public void rotate(int [] nums,int k){
        //定义一个指针
        int left;
        //创建一个新的数组，用来存放旋转后的数据
        int [] num = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
               //i不能动，所以我们要将 i 给到指针，让它去移动
                left = i;
                //前边的数据移动没有超出数组最大范围不用进入if计算
                int newI = left + k;
                //如果指针加上要移动的长度超过了当前数组长度，则需要计算
                if (newI >= nums.length){
                    newI =  left + k - nums.length;
                }
             //将计算好的下标和值存入新数组中
            num[newI] = nums[i];
        }

        System.out.println("旋转后的数组为："+Arrays.toString(num));
    }

    public static void main(String[] args) {
        //测试用例
        leetCode03 leetCode03 = new leetCode03();
        leetCode03.rotate(new int[]{-1,-100,3,99},2);
        leetCode03.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
