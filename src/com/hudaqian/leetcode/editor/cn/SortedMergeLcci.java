//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 
// 👍 88 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class SortedMergeLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
        int[] A = {1, 3, 5, 0, 0, 0}, B = {2, 4, 6};
        int m = 3, n = 3;
        solution.merge(A, m, B, m);
        System.out.print(Arrays.toString(A));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            /**
             * 省略插入以后再排序的解法
             * 这里是双指针从后往前排列的解法
             * p 2 q 2
             * 1 3 5 0 0 0
             * 2 4 6
             * p 2 q 1
             * 1 3 5 0 0 6
             * 2 4 6
             * p 1 q 1
             * 1 3 5 0 5 6
             * 2 4 6
             * p 1 q 0
             * 1 3 5 4 5 6
             * 2 4 6
             * p 0 q 0
             * 1 3 3 4 5 6
             * 2 4 6
             * p 0 q -1
             * 1 2 3 4 5 6
             * 2 4 6
             * p -1 q -1
             * 1 2 3 4 5 6
             * 2 4 6
             */
            int p = m - 1, q = n - 1;
            while (p >= 0 || q >= 0) {
                if (p < 0) {
                    // A数组没有待插入元素了
                    A[q] = B[q];
                    q--;
                    continue;
                }
                if (q < 0) {
                    //  B数组没有待插入元素了
                    return;
                }
                int num = Math.max(A[p], B[q]);
                if (A[p] > B[q]) {
                    p--;
                } else {
                    q--;
                }
                A[p + q + 1 + 1] = num;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}