//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。 
// 
//
// 示例： 
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 Sliding Window 
// 👍 50 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Map;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new GrumpyBookstoreOwner().new Solution();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5}, grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        System.out.print(solution.maxSatisfied(customers, grumpy, X));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            /**
             * 模拟+滑动窗口
             * 找连续X分钟 最多不满意的人数
             * 把最多不满意的人数 都变满意了  然后加上原本满意的人数就是结果
             * 滑动窗口直接求和
             */
            int sum = 0;
            int res = 0;
            for (int i = 0; i < X; i++) {
                if (grumpy[i] == 1) {
                    sum += customers[i];
                } else {
                    res += customers[i];
                }
            }
            int maxNum = sum;
            /**
             *  减去i-X位置上不满意的人数
             *  加上i位置上不满意的人数
             */
            for (int i = X; i < customers.length; i++) {
                if (grumpy[i - X] == 1) {
                    sum -= customers[i - X];
                }
                if (grumpy[i] == 1) {
                    sum += customers[i];
                } else {
                    res += customers[i];
                }
                maxNum = Math.max(sum, maxNum);
            }
            res += maxNum;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}