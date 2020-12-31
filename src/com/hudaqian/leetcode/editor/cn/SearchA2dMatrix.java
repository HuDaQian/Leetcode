//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 295 👎 0


package com.hudaqian.leetcode.editor.cn;

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.print(solution.searchMatrix(matrix, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            /**
             * 遍历
             */
//            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//            int mIndex = 0;
//            int m = matrix.length;
//            while (mIndex < m) {
//                int num = matrix[mIndex][0];
//                if (num == target) {
//                    return true;
//                } else if (num < target) {
//                    mIndex++;
//                } else {
//                    break;
//                }
//            }
//            if (mIndex == 0) return false;
//            mIndex--;
//            int nIndex = 0;
//            int n = matrix[0].length;
//            while (nIndex < n) {
//                int num = matrix[mIndex][nIndex];
//                if (num == target) {
//                    return true;
//                } else if (num < target) {
//                    nIndex++;
//                } else {
//                    return false;
//                }
//            }
//            return false;
            /**
             * 缩小范围 再遍历或者二分
             */
//            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//            int m = matrix.length, n = matrix[0].length;
//            int i = 0;
//            while (i < m) {
//                int left = matrix[i][0], right = matrix[i][n-1];
//                if (target < left) {
//                    return false;
//                } else if (target > right) {
//                    i++;
//                } else {
//                    break;
//                }
//            }
//            if (i == m) return false;
//            int index = 0;
//            while (index < n) {
//                int num = matrix[i][index];
//                if (num == target) {
//                    return true;
//                } else if (num < target) {
//                    index++;
//                } else {
//                    return false;
//                }
//            }
//            return false;
            /**
             * 看成大小为m*n的一维数组 直接二分
             */
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            int left = 0, right = m * n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int x = mid / n, y = mid % n;
                int num = matrix[x][y];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}