//在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击
//的中毒持续时间，你需要输出艾希的中毒状态总时长。 
//
// 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。 
//
// 
//
// 示例1: 
//
// 输入: [1,4], 2
//输出: 4
//原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
//第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
//所以最终输出 4 秒。
// 
//
// 示例2: 
//
// 输入: [1,2], 2
//输出: 3
//原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
//但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
//由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
//所以最终输出 3 。
// 
//
// 
//
// 提示： 
//
// 
// 你可以假定时间序列数组的总长度不超过 10000。 
// 你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。 
// 
// Related Topics 数组 
// 👍 127 👎 0


package com.hudaqian.leetcode.editor.cn;

public class TeemoAttacking {
    public static void main(String[] args) {
        Solution solution = new TeemoAttacking().new Solution();
        int[] timeSeries = {1, 2, 4};
        int duration = 2;
        System.out.print(solution.findPoisonedDuration(timeSeries, duration));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            /**
             * 遍历 使用start和end来表示中毒的两端
             */
            int len = timeSeries.length;
            if (len == 0) return 0;
            int start = timeSeries[0];
            int end = timeSeries[0]+duration;
            int count = 0;
            for (int i = 1; i < len; i++) {
                int nextTime = timeSeries[i];
                if (end >= nextTime) {
                    end = nextTime+duration;
                } else {
                    count+=(end-start);
                    start = timeSeries[i];
                    end = timeSeries[i]+duration;
                }
            }
            return count+(end-start);
            /**
             * 划分区块 在前后两个时间间隔内 要么中毒duration时间 要么中毒 timeSeries[i]-timeSeries[i-1]时间
             * 要记得最后还中毒了一次 所以最后要加上duration
             */
//            int len = timeSeries.length;
//            if (len == 0) return 0;
//            int res = 0;
//            for (int i = 1; i < len; i++) {
//                res += Math.min(timeSeries[i]-timeSeries[i-1], duration);
//            }
//            res+=duration;
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}