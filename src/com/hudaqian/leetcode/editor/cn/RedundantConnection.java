//在本问题中, 树指的是一个连通且无环的无向图。 
//
// 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属
//于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。 
//
// 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
// 
//
// 示例 1： 
//
// 输入: [[1,2], [1,3], [2,3]]
//输出: [2,3]
//解释: 给定的无向图为:
//  1
// / \
//2 - 3
// 
//
// 示例 2： 
//
// 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
//解释: 给定的无向图为:
//5 - 1 - 2
//    |   |
//    4 - 3
// 
//
// 注意: 
//
// 
// 输入的二维数组大小在 3 到 1000。 
// 二维数组中的整数在1到N之间，其中N是输入数组的大小。 
// 
//
// 更新(2017-09-26): 
//我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。 
// Related Topics 树 并查集 图 
// 👍 232 👎 0


package com.hudaqian.leetcode.editor.cn;

public class RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new RedundantConnection().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            /**
             * 最终结果是做成树
             * 所以这里考虑并查集
             * 如果之前的链接已经可以合并了  那么最后这条链接就是不必要的
             */
//            if (edges == null || edges.length == 0) return new int[0];
//            int len = edges.length;
//            UnionFind unionFind = new UnionFind(len+1);
//            int[] res = new int[2];
//            for (int i = 0; i < len; i++) {
//                int[] edge = edges[i];
//                if (!unionFind.Union(edge[0], edge[1])) {
//                    res = edge;
//                }
//            }
//            return res;
            /**
             * 优化一下 如果N个数字 要连成一棵树 那么需要N-1条边
             * 题目给了N条边 也就是说多了一条
             * 所以 合并的时候 如果检查出来了在同一个集合里
             * 直接返回就行
             */
            int len = edges.length;
            UnionFind unionFind = new UnionFind(len+1);
            for (int[] edge : edges) {
                if (!unionFind.Union(edge[0], edge[1])) {
                    return edge;
                }
            }
            return new int[0];
        }

        private class UnionFind {
            int[] parents;
            int[] rank;

            public UnionFind(int n) {
                this.parents = new int[n];
                this.rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                    rank[i] = 1;
                }
            }

            public int find(int x) {
                while (x != parents[x]) {
                    x = parents[x];
                }
                return x;
            }

            public boolean Union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot == yRoot) {
                    return false;
                } else {
                    if (rank[xRoot] > rank[yRoot]) {
                        parents[yRoot] = xRoot;
                    } else if (rank[yRoot] > rank[xRoot]) {
                        parents[xRoot] = yRoot;
                    } else {
                        parents[xRoot] = yRoot;
                        rank[yRoot]++;
                    }
                    return true;
                }
            }

            public boolean isConnected(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                return xRoot == yRoot;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}