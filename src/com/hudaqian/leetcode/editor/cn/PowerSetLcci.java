//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
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
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 39 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSetLcci {
        public static void main(String[] args) {
            Solution solution = new PowerSetLcci().new Solution();
            int[] nums = {1,2,3};
            System.out.print(solution.subsets(nums));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                list.addAll(addSubList(list, num));
            }
        }
        return list;
    }
    private List<List<Integer>> addSubList(List<List<Integer>> lists, int num) {
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list: lists) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(num);
            res.add(newList);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }