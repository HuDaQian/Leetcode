//n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。 
//
// 每 3 个士兵可以组成一个作战单位，分组规则如下： 
//
// 
// 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k] 
// 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[
//k] ，其中 0 <= i < j < k < n 
// 
//
// 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。 
//
// 
//
// 示例 1： 
//
// 输入：rating = [2,5,3,4,1]
//输出：3
//解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
// 
//
// 示例 2： 
//
// 输入：rating = [2,1,3]
//输出：0
//解释：根据题目条件，我们无法组建作战单位。
// 
//
// 示例 3： 
//
// 输入：rating = [1,2,3,4]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// n == rating.length 
// 1 <= n <= 200 
// 1 <= rating[i] <= 10^5 
// 
// Related Topics 数组 
// 👍 48 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class CountNumberOfTeams {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfTeams().new Solution();
        int[] rating = {1, 2, 3, 4, 7, 6, 5};
        System.out.print(solution.numTeams(rating));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTeams(int[] rating) {
            /**
             * 解法1：暴力解法 超时
             */
            int upNum = countTeams(rating, true);
            int downNum = countTeams(rating, false);
            return upNum + downNum;
        }

        private int countTeams(int[] rating, boolean rate) {
            /**
             * 两个参数 一个给数组 一个给从小到大 还是从大到小
             */
            int count = 0;
            for (int i = 0; i < rating.length; i++) {
                for (int j = i + 1; j < rating.length; j++) {
                    int firstNum = rating[i];
                    int secondNum = rating[j];
                    if ((firstNum > secondNum) ^ !rate) {
                        continue;
                    }
                    int index = j + 1;
                    while (index < rating.length) {
                        int thirdNum = rating[index];
                        if ((secondNum < thirdNum) ^ !rate) {
                            System.out.printf("%d -> %d -> %d \n", firstNum, secondNum, thirdNum);
                            count++;
                        }
                        index++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}