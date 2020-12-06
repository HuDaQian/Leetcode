//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 652 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
        public static void main(String[] args) {
            Solution solution = new Triangle().new Solution();
            List<List<Integer>> triangle = new ArrayList<>();
            triangle.add(new ArrayList<>());
            triangle.add(new ArrayList<>());
            triangle.add(new ArrayList<>());
            triangle.add(new ArrayList<>());
            triangle.get(0).add(2);
            triangle.get(1).add(3);
            triangle.get(1).add(4);
            triangle.get(2).add(6);
            triangle.get(2).add(5);
            triangle.get(2).add(7);
            triangle.get(3).add(4);
            triangle.get(3).add(1);
            triangle.get(3).add(8);
            triangle.get(3).add(3);
            System.out.print(solution.minimumTotal(triangle));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * 动态规划
         * 思路：
         */
        int[] ways = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size()-1; j > 0 ; j--) {
                if (j == list.size()-1) {
                    ways[j] = ways[j-1] + list.get(j);
                } else {
                    ways[j] = Math.min(ways[j],ways[j-1]) + list.get(j);
                }
            }
            ways[0] += list.get(0);
        }
        int minLen = Integer.MAX_VALUE;
        for (int num : ways) {
            minLen = Math.min(minLen, num);
        }
        return minLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }