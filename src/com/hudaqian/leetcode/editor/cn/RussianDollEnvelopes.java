//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 5000 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 104 
// 
// Related Topics 二分查找 动态规划 
// 👍 411 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        Solution solution = new RussianDollEnvelopes().new Solution();
        int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.print(solution.maxEnvelopes(envelopes));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            /**
             * 1,1 1
             * 2,3 2
             * 4,5 3
             * 4,6 3
             * 6,7 4
             */
            /**
             * 普通解法
             */
//            if (envelopes == null || envelopes.length == 0) return 0;
//            Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0] == 0 ? (o1[1] - o2[1]) : (o1[0] - o2[0]));
//            int count = 1, len = envelopes.length;
//            int[] dp = new int[len];
//            Arrays.fill(dp, 1);
//            for(int i = 1; i < len; i++){
//                for(int j = 0; j < i; j++){
//                    if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]){
//                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                    }
//                }
//                count = Math.max(count, dp[i]);
//            }
//            return count;
            /**
             * 1,1 1
             * 2,3 2
             * 4,6 3
             * 4,5 3
             * 6,7 4
             */
            /**
             * 骚操作
             */
            if (envelopes == null || envelopes.length == 0) return 0;
            Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0] == 0 ? (o2[1] - o1[1]) : (o1[0] - o2[0]));
            int count = 1, len = envelopes.length;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            for(int i = 1; i < len; i++){
                for(int j = 0; j < i; j++){
                    if(envelopes[j][1] < envelopes[i][1]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                count = Math.max(count, dp[i]);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}