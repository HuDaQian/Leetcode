//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 106 
// 
// Related Topics 深度优先搜索 并查集 图 二分查找 
// 👍 80 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        Solution solution = new PathWithMinimumEffort().new Solution();
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.print(solution.minimumEffortPath(heights));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            /**
             * 解法1 并查集 相邻两个格子组对 然后根据绝对值排列
             * 依次加入并查集 直到第一个格子和最后一个格子联通
             * 那么当前加入的相邻各自的绝对值就是体力最小
             */
            if (heights == null || heights.length == 0) return 0;
            int rols = heights.length;
            int cols = heights[0].length;
            List<Edge> list = new ArrayList<>();
            for (int i = 0; i < rols; i++) {
                for (int j = 0; j < cols; j++) {
                    int x = i*cols+j;
                    if (j != cols-1) {
                        // 向右
                        list.add(new Edge(x, x+1, Math.abs(heights[i][j]-heights[i][j+1])));
                    }
                    if (i != rols-1) {
                        //  向下
                        list.add(new Edge(x, x+cols, Math.abs(heights[i][j]-heights[i+1][j])));
                    }
                }
            }
            list.sort(Comparator.comparingInt(o -> o.rank));
            int ans = 0;
            UnionFind unf = new UnionFind(cols*rols);
            for (Edge edge :list) {
                unf.union(edge.x, edge.y);
                ans = edge.rank;
                if (unf.find(0) == unf.find(rols*cols-1)) {
                    break;
                }
            }
            return ans;
        }
        private class Edge {
            int x;
            int y;
            int rank;
            public Edge(int x, int y, int rank) {
                this.x = x;
                this.y = y;
                this.rank = rank;
            }
        }

        private class UnionFind{
            int[] parents;
            int[] rank;
            public UnionFind(int n) {
                this.parents = new int[n];
                this.rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }
            public int find(int x) {
                while (x != parents[x]) {
                    x = parents[x];
                }
                return x;
            }
            public void union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot != yRoot) {
                    if (rank[xRoot] > rank[yRoot]) {
                        parents[yRoot] = xRoot;
                    } else if(rank[xRoot] < rank[yRoot]) {
                        parents[xRoot] = yRoot;
                    } else {
                        parents[xRoot] = yRoot;
                        rank[yRoot]++;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}