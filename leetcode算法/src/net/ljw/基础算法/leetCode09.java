package net.ljw.基础算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LIJW
 * @date 2021/8/3 7:39 下午
 *  两数之和
 *  给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class leetCode09 {


    //方法1： 暴力破解    自己的
    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sum[0] = i;
                    sum[1] = j;
                }
            }
        }
        return sum;
    }

    //方法2： 曾经用过的方法 ，使用map集合 值做key 数组下标做value  用目标值相减 不直接全存map，边减边存
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            //不满足则存入到map集合中
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }

    //双指针 方法3
    public int[] twoSum2(int[] nums, int target) {

        int l = 0, r = 1;
        while (nums[l] + nums[r] != target ){
            if ( r == nums.length - 1){
                l++;
                r = l; //如果循环完了一次右指针，要把右指针恢复到左指针+1，这里直接赋值左指针，然后下面 r++语句使其+1，变成左指针+1
            }
            r++;
        }
        return new int[]{l,r};
    }



    public static void main(String[] args) {
        leetCode09 leetCode09 = new leetCode09();
        int[] ints = leetCode09.twoSum2(new int[]{2,7,11,15}, 26);
        System.out.println(Arrays.toString(ints));
    }
}
