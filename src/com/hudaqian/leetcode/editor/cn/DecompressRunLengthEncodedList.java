//给你一个以行程长度编码压缩的整数列表 nums 。 
//
// 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中
//有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。 
//
// 请你返回解压后的列表。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[2,4,4,4]
//解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
//第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
//最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。 
//
// 示例 2： 
//
// 输入：nums = [1,1,2,3]
//输出：[1,3,3]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 100 
// nums.length % 2 == 0 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 38 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressRunLengthEncodedList {
        public static void main(String[] args) {
            Solution solution = new DecompressRunLengthEncodedList().new Solution();
            int[] nums = {1,2,3,4};
            System.out.print(Arrays.toString(solution.decompressRLElist(nums)));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] decompressRLElist(int[] nums) {
        /**
         * 使用List类
         */
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length-1; i+=2) {
//            int p = nums[i];
//            int q = nums[i+1];
//            while (p > 0) {
//                list.add(q);
//                p--;
//            }
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();
        /**
         * 遍历两次 第一次确定数组大小 第二次放入数字
         */
        int count = 0;
        for (int i = 0; i < nums.length-1; i+=2) {
            count+=nums[i];
        }
        int[] res = new int[count];
        int ptr = 0;
        for (int i = 0; i < nums.length-1; i+=2) {
            int p = nums[i];
            int q = nums[i+1];
            while (p>0) {
                res[ptr++] = q;
                p--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }