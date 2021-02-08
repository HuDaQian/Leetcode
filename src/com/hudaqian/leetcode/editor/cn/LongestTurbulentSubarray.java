//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。 
// 
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 
//
// 返回 A 的最大湍流子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 
//
// 示例 2： 
//
// 输入：[4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 40000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 91 👎 0


package com.hudaqian.leetcode.editor.cn;

public class LongestTurbulentSubarray {
    public static void main(String[] args) {
        Solution solution = new LongestTurbulentSubarray().new Solution();
        int[] arr = {4, 8, 12, 16};
        System.out.print(solution.maxTurbulenceSize(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            if (arr == null) return 0;
            if (arr.length < 2) return arr.length;
            int l = -1, r = -1, len = arr.length, maxCount = Integer.MIN_VALUE;
            /**
             * 这里找出第一个不相等的连续数字开始
             */
            for (int i = 0; i < len - 1; i++) {
                if (arr[i + 1] != arr[i]) {
                    l = i;
                    r = i + 1;
                    break;
                }
            }
            if (l == -1) return 1;
            /**
             * 记录第一个不相等的连续数字的大小关系
             */
            boolean isUp = arr[r] - arr[l] > 0;
            r++;
            while (r < len) {
                /**
                 * 如果数字相等 那么最长的就是从l开始到r-1结束 长度为r-1 -l +1
                 */
                if (arr[r] == arr[r - 1]) {
                    maxCount = Math.max(maxCount, r - l);
                    l = r;
                    r++;
                    continue;
                }

                /**
                 * 这里使用异或来处理isUp和当前大小关系
                 */
                boolean isChange = isUp ^ (arr[r] - arr[r - 1] > 0);
                if (isChange) {
                    isUp = !isUp;
                    r++;
                } else {
                    maxCount = Math.max(maxCount, r - l);
                    l = r - 1;
                    r++;
                }
            }
            maxCount = Math.max(maxCount, r - l);
            return maxCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}