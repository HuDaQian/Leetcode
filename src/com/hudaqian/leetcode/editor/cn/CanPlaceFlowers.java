//假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。 
//
// 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True
//，不能则返回False。 
//
// 示例 1: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 1
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: flowerbed = [1,0,0,0,1], n = 2
//输出: False
// 
//
// 注意: 
//
// 
// 数组内已种好的花不会违反种植规则。 
// 输入的数组长度范围为 [1, 20000]。 
// n 是非负整数，且不会超过输入数组的大小。 
// 
// Related Topics 数组 
// 👍 200 👎 0


package com.hudaqian.leetcode.editor.cn;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new CanPlaceFlowers().new Solution();
        int[] nums = {0, 0, 0};
        int n = 2;
        System.out.print(solution.canPlaceFlowers(nums, n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            /**
             * 从1个0之后开始计数 有n个0 就是能种n/2朵
             * 10 000 1 中间三个0就是只能种1朵
             * 10 0000 1 中间四个0 就是能种2朵
             */
//        int current = 0;
//        for (int num : flowerbed) {
//            if (num == 1) {
//                //  -1/2 == 0 所以不用判断负号
//                int flowers = current /2;
//                n -= flowers;
//                //  种完早点收工
//                if (n <= 0) return true;
//                current = -1;
//            } else  {
//                current++;
//            }
//        }
//        //  边界效应 前后各补一个0
//        current++;
//        int flowers = current /2;
//        n -= flowers;
//        return n <= 0;
            /**
             * 贪心解法
             */
            if (n == 0) return true;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}