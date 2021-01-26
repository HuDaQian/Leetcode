//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 55 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {
        Solution solution = new NumberOfEquivalentDominoPairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            /**
             * map解法
             */
//            if (dominoes == null || dominoes.length == 0) return 0;
//            Map<String, Integer> map = new HashMap<>();
//            int count = 0;
//            for (int[] t : dominoes) {
//                int min = Math.max(t[0], t[1]);
//                int max = Math.min(t[0], t[1]);
//                String temp = String.format("%s-%s", min, max);
//                int number = map.getOrDefault(temp, 0);
//                count += number;
//                map.put(temp, number + 1);
//            }
//            return count;
            /**
             * 因为数组中数据都小于9 所以直接使用一个100长度的数组来记录就好
             */
            if (dominoes == null || dominoes.length == 0) return 0;
            int[] temp = new int[100];
            int count = 0;
            for (int[] t : dominoes) {
                int min = Math.min(t[0], t[1]);
                int max = Math.max(t[0], t[1]);
                count += temp[min * 10 + max];
                temp[min * 10 + max]++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}