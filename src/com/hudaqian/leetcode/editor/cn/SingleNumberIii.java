//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算 
// 👍 313 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class SingleNumberIii {
        public static void main(String[] args) {
            Solution solution = new SingleNumberIii().new Solution();
            int[] nums = {1,1,2,2,3,4};
            int[] res = solution.singleNumber(nums);
            System.out.print(res[0] + " & " +res[1]);
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;i++) {
            if (i==nums.length-1 || nums[i] != nums[i+1]) {
                res[count] = nums[i];
                count++;
            } else {
                i++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }