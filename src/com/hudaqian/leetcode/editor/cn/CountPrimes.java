//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 473 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        int n = 10;
        System.out.print(solution.countPrimes(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
//            /**
//             * 暴力破解法
//             */
//            if (n < 3) {
//                return 0;
//            }
//
//
//            Set<Integer> set = new HashSet<Integer>();
//            int count = 1;
//            for (int i = 3; i < n; i++) {
//                /**
//                 * 偶数不为质数
//                 */
//                if (i % 2 == 0) {
//                    continue;
//                }
//                boolean sign = true;
//                //用 j * j <= i 代替 j <= √i 会更好。
//                //因为我们已经排除了所有偶数，所以每次循环加二将规避偶数会减少循环次数
//                for (int j = 3; j * j <= i; j += 2) {
//                    if (i % j == 0) {
//                        sign = false;
//                        break;
//                    }
//                }
//                if (sign)
//                    count++;
//            }
//            return count;
            /**
             * 厄拉多塞筛法
             * 质数的倍数不是质数
             */
            if (n < 3) {
                return 0;
            }
            boolean[] isNotPrimes = new boolean[n];
            //  0 1
            isNotPrimes[0] = true;
            isNotPrimes[1] = true;
            int count = 1;
            for (int i = 3; i < n; i+=2) {
                if (!isNotPrimes[i]) {
                    count++;
                    for(int j = 3; i * j < n; j += 2){
                        isNotPrimes[i * j] = true;    // 将当前质数的奇数倍都设置成非质数标记 true
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}