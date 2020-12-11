//给你一个数字数组 arr 。 
//
// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。 
//
// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,5,1]
//输出：true
//解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,4]
//输出：false
//解释：无法通过重新排序得到等差数列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 1000 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 排序 数组 
// 👍 8 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {
        Solution solution = new CanMakeArithmeticProgressionFromSequence().new Solution();
        int[] nums = {13, 12, -12, 9, 9, 16, 7, -10, -20, 0, 18, -1, -20, -10, -8, 15, 15, 16, 2, 15};
        System.out.print(solution.canMakeArithmeticProgression(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            /**
             * 排序 遍历
             */
            if (arr == null || arr.length < 3) return true;
            Arrays.sort(arr);
            int temp = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] != temp) return false;
            }
            return true;
            /**
             * 哈希映射
             */
//            int min = Integer.MAX_VALUE, secMin = Integer.MAX_VALUE;
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int num : arr) {
//                if (num < min) {
//                    secMin = min;
//                    min = num;
//                } else if (num < secMin) {
//                    secMin = num;
//                }
//                map.put(num, map.getOrDefault(num, 0) + 1);
//                if (map.get(num) > 1 && map.keySet().size() > 1) return false;
//            }
//            //  前面已经对重复做了判断 所以这里可以直接用keyset判断
//            int temp = secMin - min;
//            int currentNum = secMin;
//            for (int i = 2; i < arr.length; i++) {
//                currentNum += temp;
//                if (!map.keySet().contains(currentNum)) return false;
////                if (map.getOrDefault(currentNum, 0) == 0) return false;
////                map.put(currentNum, map.getOrDefault(currentNum, 0) - 1);
//            }
//            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}