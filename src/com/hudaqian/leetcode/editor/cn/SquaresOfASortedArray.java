//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 174 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        int[] nums = {-1, 0, 1, 2, 3};
        System.out.print(Arrays.toString(solution.sortedSquares(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] A) {
            /**
             * 解法1：直接排序
             */
            int len = A.length;
            int[] result = new int[len];
            for (int i = 0; i < len; i++) {
                result[i] = A[i] * A[i];
            }
            Arrays.sort(result);
            return result;
            /**
             * 解法2：排序完平方
             */
//            int len = A.length;
//            List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
//            Collections.sort(list, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return Math.abs(o1) - Math.abs(o2);
//                }
//            });
//            int[] result = new int[len];
//            for (int i = 0; i < len; i++) {
//                result[i] = list.get(i) * list.get(i);
//            }
//            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}