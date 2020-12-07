//有一个二维矩阵 A 其中每个元素的值为 0 或 1 。 
//
// 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。 
//
// 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。 
//
// 返回尽可能高的分数。 
//
// 
//
// 
// 
//
// 示例： 
//
// 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//输出：39
//解释：
//转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
//0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20 
// 1 <= A[0].length <= 20 
// A[i][j] 是 0 或 1 
// 
// Related Topics 贪心算法 
// 👍 107 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        Solution solution = new ScoreAfterFlippingMatrix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixScore(int[][] A) {
            /**
             * 解法：贪心
             * 思路：如果保证n行结果尽可能大 那么第一行肯定都是1， 然后列里面的1尽量多
             * 所以 先进行行移动 保证每一行开头都是1 然后进行列移动 保证每一列1的数量大于0的数量
             */
            if (A.length == 0 || A[0].length == 0) return 0;
            int m = A.length, n = A[0].length;
            //  先进行行移动
            for (int i = 0; i < m; i++) {
                int[] nums = A[i];
                if (nums[0] == 0) {
                    for (int j = 0; j < n; j++) {
                        A[i][j] = A[i][j] == 0 ? 1 : 0;
                    }
                }
            }
            //  在进行列移动
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < m; j++) {
                    if (A[j][i] == 0) count++;
                }
                if (count > m / 2) {
                    for (int j = 0; j < m; j++) {
                        A[j][i] = A[j][i] == 0 ? 1 : 0;
                    }
                }
            }
            //  统计
            int num = 0;
            for (int j = 0; j < n; j++) {
                double temp = Math.pow(2, n - j - 1);
                for (int i = 0; i < m; i++) {
                    num += A[i][j] * temp;
                }
            }
            return num;
        }
        /**
         * 思路待优化
         * 不进行行移动或者列移动
         * 只是记录需要行移动的状态
         * 然后只进行 列移动的判断即可
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}