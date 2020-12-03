//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组 
// 👍 180 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.print(Arrays.toString(solution.sortArrayByParity(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            /**
             * 解法1：排序
             */
//            List<Integer> res = Arrays.stream(A).boxed().collect(Collectors.toList());
//            Collections.sort(res, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return (o1 % 2) - (o2 % 2);
//                }
//            });
//            int[] result = res.stream().mapToInt(Integer::intValue).toArray();
//            return result;
            /**
             * 解法1优化
             */
//            Integer[] integers = Arrays.stream(A).boxed().toArray(Integer[]::new);
//            Arrays.sort(integers, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return (o1%2)-(o2%2);
//                }
//            });
//            return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
            /**
             * 解法1再优化
             */
//            Integer[] integers = new Integer[A.length];
//            for (int i = 0; i < A.length; i++) {
//                integers[i] = A[i];
//            }
//            Arrays.sort(integers, (o1, o2) -> Integer.compare(o1 % 2, o2 % 2));
//            for (int i = 0; i < integers.length; i++) {
//                A[i] = integers[i];
//            }
//            return A;
            /**
             * 解法2：新建数组 两次遍历
             */
//            int[] res = new int[A.length];
//            int index = 0;
//            for (int i = 0; i < A.length; i++) {
//                if (A[i]%2 == 0){
//                    res[index] = A[i];
//                    index++;
//                }
//            }
//            for (int i=0;i<A.length;i++) {
//                if (A[i]%2 == 1) {
//                    res[index] = A[i];
//                    index++;
//                }
//            }
//            return res;
            /**
             * 解法2优化
             */
//            int[] res = new int[A.length];
//            int index = 0,lastIndex = A.length-1;
//            for (int i = 0; i < A.length; i++) {
//                if (A[i]%2 == 0) {
//                    res[index] = A[i];
//                    index++;
//                } else  {
//                    res[lastIndex] = A[i];
//                    lastIndex--;
//                }
//            }
//            return res;
            /**
             * 解法3：双指针
             * A[left]%2 A[right]%2
             * （1，0） 交换两个数字的位置
             * （0，1） 左右两个数字都对 那么向中间靠拢 left++ right--
             * （0，0） 左边数字正确 left++ 右边数字等待交换
             * （1，1） 右边数字正确 right-- 左边数字等待交换
             * 此处使用了快速排序的思想 即把每个数字当成游标来计算
             */
            int left = 0, right = A.length - 1;
            while (left < right) {
                if (A[left] % 2 - A[right] % 2 > 0) {
                    int temp = A[left];
                    A[left] = A[right];
                    A[right] = temp;
                    left++;
                    right--;
                }
                if (A[left] % 2 == 0) left++;
                if (A[right] % 2 == 1) right--;
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}