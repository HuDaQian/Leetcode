//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// 👍 141 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(Arrays.toString(solution.findDiagonalOrder(matrix)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return new int[0];
            int m = matrix.length;
            int n = matrix[0].length;
            int[] result = new int[m*n];
            int index = 0;
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n + m - 1; i++) {
                nums.clear();
                int nIndex = i < m ? 0 : (i-m)+1;
                int mIndex = i < m ? i : m-1;
                while (mIndex >= 0 && nIndex <= (n-1) ) {
                    nums.add(matrix[mIndex][nIndex]);
                    nIndex++;
                    mIndex--;
                }
                if (i %2 == 1) {
                    Collections.reverse(nums);
                }
                for (int j = 0; j < nums.size(); j++) {
                    result[index++] = nums.get(j);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}