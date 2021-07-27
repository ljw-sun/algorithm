package net.ljw.基础算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LIJW
 * @date 2021/7/27 6:45 下午
 *
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 */
public class leetCode05 {

    //1.暴力解法  特多余的解法
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    list.add(nums[i]);
                }
            }
        }
        for ( int i : nums) {
            boolean contains = list.contains(i);
            if (!contains){
                num =  i;
            }
        }
        return num;
    }

    //2.利用set的不重复性
    public int singleNumber02(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for ( int num : nums) {
            if (!set.add(num)){
                //如果添加的时候报错，则说明里面有，移除掉
                set.remove(num);
            }
        }
        //set没有直接取值的方法，只能遍历，所以我们使用toArray转成数组后强制转换，再返回
        int i = (int) set.toArray()[0];
        return i;
    }

    /**
     * 3.最简便的一种方法 异或   leetCode上的方法
     * 关于位运算有下面几个规律
     * 1^1=0;
     * 1^0=1;
     * 0^1=1;
     * 0^0=0;
     *
     * 也就说0和1异或的时候相同的异或结果为0，不同的异或结果为1，根据上面的规律我们得到
     *
     * a^a=0；自己和自己异或等于0
     * a^0=a；任何数字和0异或还等于他自己
     * a^b^c=a^c^b；异或运算具有交换律
     * @param nums
     * @return
     */
    public int singleNumber03(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            //循环异或
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        leetCode05 leetCode05 = new leetCode05();
        int i = leetCode05.singleNumber03(new int[]{4,1,2,1,2,4,5});
        System.out.println(i);
    }
    
}
