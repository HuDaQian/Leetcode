//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 579 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        int n = 10;
        System.out.print(solution.nthUglyNumber(n));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            if (n <=0 ) return -1;
            PriorityQueue<Long> heap = new PriorityQueue<>();
            Set<Long> set = new HashSet<>();
            set.add((long)1);
            heap.offer((long)1);
            long cur = 1;
            for (int i = 0; i < n; i++) {
                if (set.add(cur*2)) heap.offer(cur * 2);
                if (set.add(cur*3)) heap.offer(cur * 3);
                if (set.add(cur*5)) heap.offer(cur * 5);
                cur = heap.poll();
            }
            return (int)cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}