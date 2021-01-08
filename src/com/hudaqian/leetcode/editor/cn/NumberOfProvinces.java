//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 467 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.print(solution.findCircleNum(isConnected));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            /**
             * 并查集 压缩路径解法
             */
            if (isConnected == null || isConnected.length == 0 || isConnected[0].length == 0) return 0;
            int len = isConnected.length;
            int[] parents = new int[len];
            Arrays.fill(parents, -1);
            int[] rank = new int[len];
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (isConnected[i][j] == 1) {
                        union(parents, i, j, rank);
                    }
                }
            }
            int circleNum = 0;
            for (int i = 0; i < len; i++) {
                if (parents[i] == -1) circleNum++;
            }
            return circleNum;
        }

        private void union(int[] parents, int x, int y, int[] rank) {
            int xRoot = findRoot(parents, x);
            int yRoot = findRoot(parents, y);
            if (xRoot != yRoot) {
                if (rank[xRoot] > rank[yRoot]) {
                    parents[yRoot] = xRoot;
                } else if (rank[yRoot] > rank[xRoot]) {
                    parents[xRoot] = yRoot;
                } else {
                    parents[xRoot] = yRoot;
                    rank[yRoot]++;
                }
            }
        }

        private int findRoot(int[] parents, int index) {
            while (parents[index] != -1) {
                index = parents[index];
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}