//给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。 
//
// 如果不能形成任何面积不为零的三角形，返回 0。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[2,1,2]
//输出：5
// 
//
// 示例 2： 
//
// 输入：[1,2,1]
//输出：0
// 
//
// 示例 3： 
//
// 输入：[3,2,3,4]
//输出：10
// 
//
// 示例 4： 
//
// 输入：[3,6,2,3]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 10000 
// 1 <= A[i] <= 10^6 
// 
// Related Topics 排序 数学 
// 👍 125 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        Solution solution = new LargestPerimeterTriangle().new Solution();
        int[] nums = {2,1,2};
        System.out.print(solution.largestPerimeter(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPerimeter(int[] A) {
            /**
             * 解法1：排序+三指针
             * 超时
             */
            Arrays.sort(A);
            if (A.length < 2) return 0;
            int max = 0;
            for (int i = 0; i < A.length - 2; i++) {
                for (int j = i + 1; j < A.length - 1; j++) {
                    for (int k = j + 1; k < A.length; k++) {
                        if (A[k] >= A[j] + A[i]) {
                            break;
                        } else {
                            max = Math.max(max, A[k] + A[j] + A[i]);
                        }
                    }
                }
            }
            return max;
            /**
             * 解法2：排序+贪心
             * 如果要想得到最大的周长
             * 那么 排序完成之后 最大的三个数字 如果能组成三角形 那么肯定是最大的
             * 如果不能 那么最后一个数字肯定不能与其他数字组成三角形 所以窗口向左移动一位
             */
//        Arrays.sort(A);
//        for (int i = A.length-1; i >1 ; i--) {
//            if (A[i-2] + A[i-1] > A[i]) {
//                return A[i] + A[i-1] + A[i-2];
//            }
//        }
//        return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}