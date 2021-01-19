//给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。 
//
// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 
//val 的绝对值。 
//
// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//输出：20
//解释：
//
//我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
//注意到任意两个点之间只有唯一一条路径互相到达。
// 
//
// 示例 2： 
//
// 
//输入：points = [[3,12],[-2,5],[-4,1]]
//输出：18
// 
//
// 示例 3： 
//
// 
//输入：points = [[0,0],[1,1],[1,0],[-1,1]]
//输出：4
// 
//
// 示例 4： 
//
// 
//输入：points = [[-1000000,-1000000],[1000000,1000000]]
//输出：4000000
// 
//
// 示例 5： 
//
// 
//输入：points = [[0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 1000 
// -106 <= xi, yi <= 106 
// 所有点 (xi, yi) 两两不同。 
// 
// Related Topics 并查集 
// 👍 60 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new MinCostToConnectAllPoints().new Solution();
        int[][] points = {{-14,-14},{-18,5},{18,-10},{18,18},{10,-2}};
        System.out.print(solution.minCostConnectPoints(points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] parents;
        public int minCostConnectPoints(int[][] points) {
            /**
             * 两种思路
             * 第一是 不断加入最小边  然后通过并查集来确定是否连通
             * 第二是 从点入手  一步一步全部连通
             */
            if (points == null || points.length <= 1) return 0;
            int len = points.length;
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    edges.add(new Edge(i, j, Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
                }
            }
            Collections.sort(edges, Comparator.comparingInt(o -> o.val));
            parents = new int[len];
            for (int i = 0; i < len; i++) {
                parents[i] = i;
            }
            //  边的数量
            int count = 0;
            int sum = 0;
            for (Edge edge : edges) {
                int xRoot = find(edge.x);
                int yRoot = find(edge.y);
                if (xRoot != yRoot) {
                    //  合并
                    parents[xRoot] = yRoot;
//                    System.out.print(edge);
                    sum += edge.val;
                    if (++count == len-1) {
                        break;
                    }
                }
            }
            return sum;
        }
        private int find(int x) {
            while (x != parents[x]) {
                x = parents[x];
            }
            return parents[x];
        }
        
        private class Edge {
            int x;
            int y;
            int val;
            public Edge(int a, int b,int lenth) {
                this.x = a;
                this.y = b;
                this.val = lenth;
            }

            @Override
            public String toString() {
                return "Edge{" +
                        "x=" + x +
                        ", y=" + y +
                        ", val=" + val +
                        '}' + '\n';
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}