//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 791 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroes {
        public static void main(String[] args) {
            Solution solution = new MoveZeroes().new Solution();
            int nums[] = {1,2};
            solution.moveZeroes(nums);
            System.out.print(Arrays.asList(nums));

        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
//        int p = 0;
//        while (p<nums.length && nums[p] != 0) {
//            p++;
//        }
//        if (p == nums.length) {
//            return;
//        }
//        int i = p+1;
//        while (i<nums.length) {
//            if (nums[i] != 0) {
//                nums[p] = nums[i];
//                nums[i] = 0;
//                p++;
//            }
//            i++;
//        }
        /**
         * 第二种处理 多一步判断 实际时间复杂度相同
         * 当然也可以记录p的坐标 最后再跑for循环赋0
         */
        int i=0,p=0;
        while(i<nums.length) {
            if (nums[i] != 0) {
                if (i > p) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
            i++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }