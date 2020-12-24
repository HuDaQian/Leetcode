//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 397 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        System.out.print(solution.candy(ratings));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            /**
             * 贪心解法
             * 按题目要求
             * 从左往右看的话 如果后一个数大于前一个数字 那么糖果+1 否则糖果数=1
             * 这样会导致递减数列一直是1 所以
             * 再从右往左看 将不符合的数字填充进去即可
             */
            int len = ratings.length;
            if (len == 0) return 0;
            int[] candys = new int[len];
            int[] candys2 = new int[len];
            candys[0] = 1;
            candys2[len - 1] = 1;
            for (int i = 1; i < len; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candys[i] = candys[i - 1] + 1;
                } else {
                    candys[i] = 1;
                }
            }

            //  以为后边的遍历 会从倒数第二个数字开始计算 并且直接计算总和
            //  省去最后一步再取两个数组相同位置最大元素的比较
            //  所以这里先一步比较了从左向右规则 和 从右向左规则最后一个值的大小 等于下边的语句
//            int count = candys[len - 1] > candys2[len - 1] ? candys[len-1] : candys2[len - 1];
            int count = candys[len-1];
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candys2[i] = candys2[i + 1] + 1;
                } else {
                    candys2[i] = 1;
                }
                count += Math.max(candys[i], candys2[i]);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}