//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 369 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        int nuwRows = 5;
        System.out.print(solution.generate(nuwRows));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();
            if (numRows == 0) {
                return triangle;
            }
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);
            for (int rowNum = 1; rowNum < numRows; rowNum++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> preRow = triangle.get(rowNum - 1);
                row.add(1);
                for (int i = 1; i < rowNum; i++) {
                    row.add(preRow.get(i - 1) + preRow.get(i));
                }
                row.add(1);
                triangle.add(row);
            }
            return triangle;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}