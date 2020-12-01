//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 505 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
        int[] nums = {1,2,3,4,4,5,7,7};
        System.out.print(solution.findDisappearedNumbers(nums).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            /**
             * 解法1：使用额外空间的做法1 哈希表
             */
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int num:nums) {
//                map.put(num,map.getOrDefault(num,0)+1);
//            }
//            List<Integer> result = new ArrayList<>();
//            for (int i = 1; i <= nums.length; i++) {
//                if (!map.containsKey(i)) {
//                    result.add(i);
//                }
//            }
//            return result;
            /**
             * 解法2：使用了额外的空间2 数组
             */
            //  注意最后比较的时候 要排除0 并加上后边的数字
            boolean[] temp = new boolean[nums.length];
            for (int num:nums) {
                temp[num-1] = true;
            }
            List<Integer> result = new ArrayList<>();
            for (int i=0;i<temp.length;i++) {
                if (!temp[i]) {
                    result.add(i+1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}