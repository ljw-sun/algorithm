package net.ljw.基础算法;

import java.util.Arrays;

/**
 * @author LIJW
 * @date 2021/8/2 7:43 下午
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class leetCode08 {

    //自己的方法
    public void moveZeroes(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == 0){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    //网上方法
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        //定义一个指针，代表数组下标
        int index = 0;
        //先遍历一次 ， 将不为0的全放到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
               nums[index++] = nums[i];
            }
        }
        //然后在上面for循环后的index后面全为0
        while (index < nums.length){
            nums[index++] = 0;
        }


    }

    public static void main(String[] args) {
        leetCode08 leetCode08 = new leetCode08();
        leetCode08.moveZeroes(new int[]{0,1,0,3,12});
    }
}
