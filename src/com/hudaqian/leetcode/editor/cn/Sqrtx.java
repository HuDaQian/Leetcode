//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 545 👎 0


package com.hudaqian.leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        int x = 2147395599;
        System.out.print(solution.mySqrt(x));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            /**
             * 二分法查找平方根 注意整数类型有上限
             */
            int left = 0, right = x;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                long temp = (long)middle * middle;
                if (temp == x) {
                    return middle;
                } else if (temp < x) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return left-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}