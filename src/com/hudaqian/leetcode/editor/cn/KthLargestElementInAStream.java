//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 104 
// 0 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// -104 <= val <= 104 
// 最多调用 add 方法 104 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
// Related Topics 堆 设计 
// 👍 198 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
//        [[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
        int[] nums = {0};
        KthLargest k = new KthLargestElementInAStream().new KthLargest(2, nums);
        k.add(-1);
        k.add(1);
        k.add(-2);
        k.add(-4);
        k.add(3);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        int[] uppers;
        int des = 0;

        public KthLargest(int k, int[] nums) {
            this.uppers = new int[k];
            int len = nums.length;
            int[] temp = Arrays.copyOf(nums, len);
            Arrays.sort(temp);
            Arrays.fill(uppers, Integer.MAX_VALUE);
            if (k > len) {
                System.arraycopy(temp,0,uppers,0,len);
            } else {
                System.arraycopy(temp,len-k,uppers,0,k);
            }
            des = Math.max(k-len, 0);
        }

        public int add(int val) {
            int k = uppers.length;
            if (k == 0) return -1;
            if (des == 0) {
                if (uppers[0] < val) {
                    uppers[0] = val;
                    for (int i = 1; i < k; i++) {
                        if (uppers[i] >= val) {
                            break;
                        } else {
                            int temp = uppers[i];
                            uppers[i] = val;
                            uppers[i - 1] = temp;
                        }
                    }
                }
            } else {
                if (uppers[k-1] == Integer.MAX_VALUE) {
                    uppers[k-1] = val;
                }
                for (int i = k-1; i > 0 ; i--) {
                    if (uppers[i-1] <= val) {
                        break;
                    } else {
                        int temp = uppers[i - 1];
                        uppers[i - 1] = val;
                        uppers[i] = temp;
                    }
                }
                des--;
            }
            return uppers[0];
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}