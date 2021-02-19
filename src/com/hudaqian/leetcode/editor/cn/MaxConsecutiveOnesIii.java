//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 双指针 Sliding Window 
// 👍 165 👎 0


package com.hudaqian.leetcode.editor.cn;

public class MaxConsecutiveOnesIii {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        int[] A = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int K = 3;
        System.out.print(solution.longestOnes(A, K));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestOnes(int[] A, int K) {
            //  双指针解法
//            if (A == null || A.length == 0) return 0;
//            int l = 0, r = 0, len = A.length, res = 0, ptr = K;
//            while (r < len) {
//                if (A[r] == 0) {
//                    if (ptr > 0) {
//                        ptr--;
//                    } else {
//                        while (l < r) {
//                            if (A[l] == 0) {
//                                break;
//                            }
//                            l++;
//                        }
//                        l++;
//                    }
//                }
//                res = Math.max(res, r - l + 1);
//                r++;
//            }
//            return res;
            /**
             * 滑动窗口解法
             * 使用元素和来代替双指针坐标
             */
            int n = A.length;
            int left = 0, lsum = 0, rsum = 0;
            int res = 0;
            for (int right = 0; right < n; ++right) {
                rsum += 1 - A[right];
                while (lsum < rsum - K) {
                    lsum += 1 - A[left];
                    ++left;
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}