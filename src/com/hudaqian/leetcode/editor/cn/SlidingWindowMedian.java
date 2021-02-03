//中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
// Related Topics Sliding Window 
// 👍 150 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMedian().new Solution();
        int[] nums = {2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647};
        int k = 2;
        System.out.print(Arrays.toString(solution.medianSlidingWindow(nums, k)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            List<Integer> list;
            int ptr = 0, len = nums.length;
            double[] result = new double[len - k + 1];
            int[] tempNumbers = new int[k];
            if (k >= 0) System.arraycopy(nums, 0, tempNumbers, 0, k);
            boolean isSingle = k % 2 != 0;
            long[] temp = getMediumNumber(Arrays.copyOf(tempNumbers, k), isSingle);
            list = getTempMidNumbers(temp, isSingle);
            if (isSingle) {
                result[ptr] = temp[0];
            } else {
                result[ptr] = (double) (temp[0] + temp[1]) / 2;
            }

            while (ptr < (len - k)) {
                int lastNumber = nums[ptr];
                int newNumber = nums[ptr + k];
                tempNumbers[ptr % k] = newNumber;
                if ((lastNumber < list.get(0) && newNumber < list.get(0)) || (lastNumber > list.get(1) && newNumber > list.get(1))) {
                    result[ptr + 1] = result[ptr++];
                } else {
                    long[] temps = getMediumNumber(Arrays.copyOf(tempNumbers, k), isSingle);
                    list = getTempMidNumbers(temps, isSingle);
                    if (isSingle) {
                        result[++ptr] = temps[0];
                    } else {
                        result[++ptr] = (double) (temps[0] + temps[1]) / 2;
                    }
                }
            }
            return result;
        }

        private List<Integer> getTempMidNumbers(long[] tempNums, boolean isSingle) {
            List<Integer> list = new ArrayList();
            if (isSingle) {
                list.add(Math.toIntExact(tempNums[0]));
                list.add(Math.toIntExact(tempNums[0]));
            } else {
                list.add(Math.toIntExact(tempNums[0]));
                list.add(Math.toIntExact(tempNums[1]));
            }
            return list;
        }

        private long[] getMediumNumber(int[] tempNums, boolean isSingle) {
            int len = tempNums.length;
            Arrays.sort(tempNums);
            if (isSingle) {
                long[] result = new long[1];
                result[0] = tempNums[len / 2];
                return result;
            } else {
                long[] result = new long[2];
                result[0] = tempNums[len / 2 - 1];
                result[1] = tempNums[len / 2];
                return result;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}