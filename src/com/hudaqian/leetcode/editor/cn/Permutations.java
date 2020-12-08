//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1027 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = {1,2,3};
        System.out.print(solution.permute(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            /**
             * 回溯经典案例
             */
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            backTrack(res, temp, 0, temp.size());
            return res;
        }

        private void backTrack(List<List<Integer>> res, List<Integer> temp, int start, int len) {
            if (start == len) {
                res.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start; i < len; i++) {
                swap(temp, i, start);
                backTrack(res, temp, start+1, len);
                swap(temp, i, start);
            }
        }

        private void swap(List<Integer> temp, int start, int end) {
            int tempNum = temp.get(start);
            temp.set(start, temp.get(end));
            temp.set(end, tempNum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}