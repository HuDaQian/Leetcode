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
            Integer[] integers = new Integer[A.length];
            for (int i = 0; i < A.length; i++) {
                integers[i] = A[i];
            }
            Arrays.sort(integers, (o1, o2) -> Integer.compare(o1 % 2, o2 % 2));
            for (int i = 0; i < integers.length; i++) {
                A[i] = integers[i];
            }
            return A;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}