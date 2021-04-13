//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 538 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        int[] nums = {34323,3432};
        System.out.print(solution.largestNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(integers, this::checkAToB);
            StringBuffer sb = new StringBuffer();
            boolean isStart = true;
            for (Integer num : integers) {
                if (!isStart || num != 0) {
                    sb.append(num);
                    isStart = false;
                }
            }
            return sb.toString().isEmpty() ? "0" : sb.toString();
        }
        private int checkAToB(int aNum, int bNum) {
            String aStr = String.valueOf(aNum);

            String bStr = String.valueOf(bNum);
            int len = aStr.length() + bStr.length();
            for (int i = 0; i < len; i++) {
                char aChar = i >= aStr.length() ? bStr.charAt(i-aStr.length()):aStr.charAt(i);
                char bChar = i >= bStr.length() ? aStr.charAt(i-bStr.length()):bStr.charAt(i);

                int aTmp = Integer.parseInt(String.valueOf(aChar));
                int bTmp = Integer.parseInt(String.valueOf(bChar));
                if (aTmp == bTmp) continue;
                return bTmp - aTmp;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}