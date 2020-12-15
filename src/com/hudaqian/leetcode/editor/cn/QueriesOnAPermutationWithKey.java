//给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=q
//ueries.length-1）： 
//
// 
// 一开始，排列 P=[1,2,3,...,m]。 
// 对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置（即下标为 0
// 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。 
// 
//
// 请你以数组形式返回待查数组 queries 的查询结果。 
//
// 
//
// 示例 1： 
//
// 输入：queries = [3,1,2,1], m = 5
//输出：[2,1,2,1] 
//解释：待查数组 queries 处理如下：
//对于 i=0: queries[i]=3, P=[1,2,3,4,5], 3 在 P 中的位置是 2，接着我们把 3 移动到 P 的起始位置，得到 P=[3
//,1,2,4,5] 。
//对于 i=1: queries[i]=1, P=[3,1,2,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1
//,3,2,4,5] 。 
//对于 i=2: queries[i]=2, P=[1,3,2,4,5], 2 在 P 中的位置是 2，接着我们把 2 移动到 P 的起始位置，得到 P=[2
//,1,3,4,5] 。
//对于 i=3: queries[i]=1, P=[2,1,3,4,5], 1 在 P 中的位置是 1，接着我们把 1 移动到 P 的起始位置，得到 P=[1
//,2,3,4,5] 。 
//因此，返回的结果数组为 [2,1,2,1] 。  
// 
//
// 示例 2： 
//
// 输入：queries = [4,1,2,2], m = 4
//输出：[3,1,2,0]
// 
//
// 示例 3： 
//
// 输入：queries = [7,5,5,8,3], m = 8
//输出：[6,5,0,7,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m <= 10^3 
// 1 <= queries.length <= m 
// 1 <= queries[i] <= m 
// 
// Related Topics 数组 
// 👍 16 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class QueriesOnAPermutationWithKey {
    public static void main(String[] args) {
        Solution solution = new QueriesOnAPermutationWithKey().new Solution();
        int[] queries = {3, 1, 2, 1};
        int m = 5;
        System.out.print(Arrays.toString(solution.processQueries(queries, m)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] processQueries(int[] queries, int m) {
            /**
             * 暴力模拟
             */
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = i + 1;
            }
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int index = getIndex(nums, queries[i]);
                reSortNums(nums, index);
                res[i] = index;
            }
            return res;
        }

        private int getIndex(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }

        private void reSortNums(int[] nums, int endIndex) {
            /**
             * 把endIndex上的数字调整到首位
             */
            int temp = nums[endIndex];
            int ptr = endIndex;
            while (ptr > 0) {
                nums[ptr] = nums[ptr-1];
                ptr--;
            }
            nums[0] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}