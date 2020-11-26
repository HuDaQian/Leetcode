//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 974 👎 0


package com.hudaqian.leetcode.editor.cn;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        int[] num = {2,5,9,6,9,3,8,9,7,1};
        System.out.print(solution.findDuplicate(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            /**
             * 双指针 因为nums里的数字最大为n nums长度为n+1
             * 所以 可以把里面的数字 都当成指针
             * 这样就类似于链表问题了
             */
//            int slow = 0, fast = 0;
//            do {
//                slow = nums[slow];
//                fast = nums[nums[fast]];
//            } while (slow != fast);
//            slow = 0;
//            while (slow != fast) {
//                slow = nums[slow];
//                fast = nums[fast];
//            }
//            return slow;
            /**
             * 二分法的骚操作
             */
            int n = nums.length;
            int l = 1, r = n - 1, ans = -1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                int cnt = 0;
                for (int i = 0; i < n; ++i) {
                    if (nums[i] <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                    ans = mid;
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}