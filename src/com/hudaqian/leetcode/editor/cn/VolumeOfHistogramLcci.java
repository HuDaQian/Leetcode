//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 31 👎 0


package com.hudaqian.leetcode.editor.cn;

public class VolumeOfHistogramLcci {
    public static void main(String[] args) {
        Solution solution = new VolumeOfHistogramLcci().new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(solution.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            /**
             * 先找最高的  然后再找第二高的  直到找到左右边界
             * 归并解法
             */
            int start = -1, end = -1, maxIndex = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    if (start == -1) {
                        start = i;
                    }
                    end = i;
                }
                if (height[i] > height[maxIndex]) {
                    maxIndex = i;
                }
            }
            int left = getTrap(height, -1, start, end, maxIndex - 1);
            int right = getTrap(height, 1, start, end, maxIndex + 1);
            return left + right;
        }


        private int getTrap(int[] height, int vetor, int start, int end, int index) {
            /**
             * 递归向两边查找 找高一点的作为容器的边
             */
            if (index <= start || index >= end) return 0;
            int ptr = index, secondHeight = Integer.MIN_VALUE, secondIndex = index;
            while (ptr >= start && ptr <= end) {
                if (height[ptr] > secondHeight) {
                    secondHeight = height[ptr];
                    secondIndex = ptr;
                }
                ptr += vetor;
            }
            int count = getTrap(height, vetor, start, end, secondIndex + vetor);
            count += secondHeight * Math.abs(index - secondIndex);
            if (vetor == -1) {
                for (int i = secondIndex+1; i <=index ; i++) {
                    count-=height[i];
                }
            } else {
                for (int i = secondIndex-1; i >= index ; i--) {
                    count-=height[i];
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}