package net.ljw.基础算法;

import java.util.*;

/**
 * @author LIJW
 * @date 2021/7/28 5:47 下午
 * 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class leetCode06 {

    //自己的方法
    public int[] intersect(int[] nums1, int[] nums2) {
        //先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //定义2个指针  分别指向num1 num2
        int n1 = 0 ,n2 = 0;
        List<Integer> list = new ArrayList<>();
        while (n1 < nums1.length && n2 < nums2.length){
            if (nums1[n1] < nums2[n2]){
                // 如果i指向的值小于j指向的值，，说明i指向的值小了，i往后移一步
                n1++;
            }else if (nums1[n1] > nums2[n2]){
                // 如果i指向的值大于j指向的值，说明j指向的值小了，j往后移一步
                n2++;
            }else {
                // 如果i和j指向的值相同，说明这两个值是重复的，把他加入到集合list中，然后i和j同时都往后移一步
                list.add(nums1[n1]);
                n1++;
                n2++;
            }
        }

        int[] ints = new int[list.size()];
        int index = 0;
        //将集合转为数组
        for (int i = 0; i < list.size(); i++) {
            ints[index++] = list.get(i);
        }

        return ints;
    }

    public static void main(String[] args) {
        leetCode06 leetCode06 = new leetCode06();
        int[] intersect = leetCode06.intersect(new int[]{9,4,9,8,4}, new int[]{4,9,5});
        System.out.println(Arrays.toString(intersect));

    }
}
