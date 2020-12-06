//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 898 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            for (int num : nums) {
                list.addAll(addSubList(list, num));
            }
            return list;
        }

        private List<List<Integer>> addSubList(List<List<Integer>> lists, int num) {
            List<List<Integer>> res = new ArrayList<>();
            for (List<Integer> list : lists) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                res.add(newList);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}