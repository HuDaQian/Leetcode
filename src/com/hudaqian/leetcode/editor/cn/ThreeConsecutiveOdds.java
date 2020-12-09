//给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,6,4,1]
//输出：false
//解释：不存在连续三个元素都是奇数的情况。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,34,3,4,5,7,23,12]
//输出：true
//解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 
// Related Topics 数组 
// 👍 5 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        Solution solution = new ThreeConsecutiveOdds().new Solution();
        int[] arr = {1,2,3,4,5,6,7,8,9,5,1};
        System.out.print(solution.threeConsecutiveOdds(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            /**
             * 枚举解法
             */
            if (arr == null || arr.length < 3) return false;
            int oddCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    oddCount = 0;
                } else {
                    oddCount++;
                    if (oddCount == 3) return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}