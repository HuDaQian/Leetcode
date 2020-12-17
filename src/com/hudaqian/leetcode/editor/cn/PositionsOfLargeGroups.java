//在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。 
//
// 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。 
//
// 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示
//为 [3,6] 。 
//
// 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。 
//
// 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abbxxxxzzy"
//输出：[[3,6]]
//解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc"
//输出：[]
//解释："a","b" 和 "c" 均不是符合要求的较大分组。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcdddeeeeaabbbcd"
//输出：[[3,5],[6,9],[12,14]]
//解释：较大分组为 "ddd", "eeee" 和 "bbb" 
//
// 示例 4： 
//
// 
//输入：s = "aba"
//输出：[]
// 
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅含小写英文字母 
// 
// Related Topics 数组 
// 👍 61 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {
    public static void main(String[] args) {
        Solution solution = new PositionsOfLargeGroups().new Solution();
        String s = "aaa";
        System.out.print(solution.largeGroupPositions(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
//            List<List<Integer>> result = new ArrayList<>();
//            if (s == null || s.length() == 0) return result;
//            int p = 0;
//            char[] arr = s.toCharArray();
//            for (int i = 1; i < s.length(); i++) {
//                if (arr[i] != arr[p]) {
//                    if (i - p >= 3) {
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(p);
//                        temp.add(i - 1);
//                        result.add(temp);
//                    }
//                    p = i;
//                }
//            }
//            if (arr[s.length()-1] == arr[p] && s.length()-1-p >= 2) {
//                List<Integer> temp = new ArrayList<>();
//                temp.add(p);
//                temp.add(s.length()-1);
//                result.add(temp);
//            }
//            return result;
            /**
             * 双指针解法
             */
            List<List<Integer>> result = new ArrayList<>();
            if (s == null || s.length() == 0) return result;
            int p = 0;
            char[] arrs = s.toCharArray();
            for (int i = 0; i < arrs.length; i++) {
                if (i == arrs.length - 1 || arrs[i] != arrs[i + 1]) {
                    if (i - p + 1 >= 3) result.add(Arrays.asList(p, i));
                    p = i + 1;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}