//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 787 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {1,2,7,6,3,3,4,5,6,5,4,3,2,1};
        System.out.print(String.format("%d",solution.findKthLargest(nums,2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            buildMaxHeap(nums, heapSize);
            for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
                swap(nums, 0, i);
                --heapSize;
                maxHeapify(nums, 0, heapSize);
            }
            return nums[0];
        }

        public void buildMaxHeap(int[] a, int heapSize) {
            for (int i = heapSize / 2; i >= 0; --i) {
                maxHeapify(a, i, heapSize);
            }
        }

        public void maxHeapify(int[] a, int i, int heapSize) {
            int l = i * 2 + 1, r = i * 2 + 2, largest = i;
            if (l < heapSize && a[l] > a[largest]) {
                largest = l;
            }
            if (r < heapSize && a[r] > a[largest]) {
                largest = r;
            }
            if (largest != i) {
                swap(a, i, largest);
                maxHeapify(a, largest, heapSize);
            }
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}