//在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0
//。 
//
// 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [0,1,0], K = 1
//输出：2
//解释：先翻转 A[0]，然后翻转 A[2]。
// 
//
// 示例 2： 
//
// 
//输入：A = [1,1,0], K = 2
//输出：-1
//解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
// 
//
// 示例 3： 
//
// 
//输入：A = [0,0,0,1,0,1,1,0], K = 3
//输出：3
//解释：
//翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
//翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
//翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// 1 <= K <= A.length 
// 
// Related Topics 贪心算法 Sliding Window 
// 👍 89 👎 0


package com.hudaqian.leetcode.editor.cn;

public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfKConsecutiveBitFlips().new Solution();
        int[] A = {0,1,0,0,1,0};
        int K = 4;
        System.out.print(solution.minKBitFlips(A, K));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minKBitFlips(int[] A, int K) {
            /**
             * 暴力解法
             */
//            int res = 0, len = A.length;
//            for (int i = 0; i <= len - K; i++) {
//                if (A[i] == 0) {
//                    res++;
//                    for (int j = 0; j < K; j++) {
//                        A[i + j] ^= 1;
//                    }
//                }
//            }
//            for (int i = len - K; i < len; i++) {
//                if (A[i] == 0) return -1;
//            }
//            return res;
            /**
             * 差分数组解法
             * 差分数组就是只记录后边元素与前面元素的差 当这个子数组整体进行修改的时候 只有区间左侧元素和区间右侧+1的元素进行了修改
             */
            int res = 0, revCnt = 0, len = A.length;
            int[] diff = new int[len + 1];
            for (int i = 0; i < len; i++) {
                revCnt ^= diff[i];
//                revCnt += diff[i];
//                if ((A[i] + revCnt) % 2 == 0) {
                if ((A[i] ^ revCnt) == 0) {
                    if (i + K > len) return -1;
                    res++;
                    revCnt ^= 1;
                    diff[i + K] ^= 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}