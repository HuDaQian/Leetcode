//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 189 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        int rowIndex = 5;
        System.out.print(solution.getRow(rowIndex));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<>();
            while (rowIndex >= 0) {
                rowIndex--;
                list.add(1);
                for (int i = list.size() - 2; i > 0; i--) {
                    list.set(i, list.get(i) + list.get(i - 1));
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//
//    Tips:
//    1
//    11
//    121
//    ==> 1211 1231 1331
//    1331
//    ==> 13311 13341 13641 14641
//    14641
//    第n个元素为第n-1个元素+第n个元素 所以用动态规划做
}