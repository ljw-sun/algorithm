package net.ljw.基础算法;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LIJW
 * @date 2021/7/26 8:12 下午
 *  存在重复元素
 *
 *  给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class leetCode04 {

    //1.暴力破解
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //2.排序后比较
    public boolean containsDuplicate01(int[] nums) {
        //java Arrays中排序数组的方法
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }


    //3.使用set集合，重复的数据添加到set集合中会报false
    public boolean containsDuplicate02(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num: nums) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        leetCode04 leetCode04 = new leetCode04();
        boolean b = leetCode04.containsDuplicate01(new int[]{1,2,3,4,1});
        System.out.println(b);
    }
}
