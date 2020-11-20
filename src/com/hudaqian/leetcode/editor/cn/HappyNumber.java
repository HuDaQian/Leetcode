//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学 
// 👍 482 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        System.out.print(solution.isHappy(19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            /**
             * 不快乐数终会重复
             * 递归+哈希表记录
             */
            Set<Integer> set = new HashSet<>();
            int current = n;
            while (current != 1) {
                if (!set.add(current)){
                    return false;
                }
                current = getSqure(current);
            }
            return true;
        }

        private int getSqure(int num) {
            if (num / 10 == 0) {
                return num * num;
            }
            int last = num % 10;
            return last * last + getSqure(num/10);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}