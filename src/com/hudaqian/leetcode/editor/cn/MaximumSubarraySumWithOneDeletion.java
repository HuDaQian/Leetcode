//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。 
//
// 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元
//素总和是所有子数组之中最大的。 
//
// 注意，删除一个元素后，子数组 不能为空。 
//
// 请看示例： 
//
// 示例 1： 
//
// 输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。 
//
// 示例 2： 
//
// 输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
// 
//
// 示例 3： 
//
// 输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -10^4 <= arr[i] <= 10^4 
// 
// Related Topics 动态规划 
// 👍 86 👎 0


package com.hudaqian.leetcode.editor.cn;

public class MaximumSubarraySumWithOneDeletion {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarraySumWithOneDeletion().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] arr) {
            if (arr == null || arr.length == 0) return 0;
            int len = arr.length;
            int[] dp1 = new int[len+1];
            int[] dp2 = new int[len+1];
            dp1[0] = 0;
            dp2[0] = 0;
            dp1[1] = arr[0];
            dp2[1] = arr[0];
            int maxNumber = 0;
            for (int i = 2; i < len; i++) {

            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}