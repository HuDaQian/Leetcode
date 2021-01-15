//n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。 
//
// 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。 
//
// 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//输出：5
//解释：一种移除 5 块石头的方法如下所示：
//1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
//2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
//3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
//4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
//5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
//石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。 
//
// 示例 2： 
//
// 
//输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//输出：3
//解释：一种移除 3 块石头的方法如下所示：
//1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
//2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
//3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
//石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。 
//
// 示例 3： 
//
// 
//输入：stones = [[0,0]]
//输出：0
//解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 1000 
// 0 <= xi, yi <= 104 
// 不会有两块石头放在同一个坐标点上 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 121 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        Solution solution = new MostStonesRemovedWithSameRowOrColumn().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeStones(int[][] stones) {
            /**
             * 思路是：一定可以把一个连通图里的所有顶点根据这个规则删到只剩下一个顶点!
             * 一个点 代表的就是 两条边的联通
             * （x，y）代表的就是横坐标等于x的边 和纵坐标等于y的边
             * 我们通过将一条边+10000来区别两条边（题目有说坐标点小于10^4）
             */
            if (stones == null || stones.length == 0) return 0;
            int len = stones.length;
            UnionFind unionFind = new UnionFind(20001);
            for (int i = 0; i < len; i++) {
                unionFind.Union(stones[i][0], stones[i][1]+10000);
            }
            return len - unionFind.getUnionCount();
        }
        private class UnionFind {
            private int[] parents;
            public UnionFind(int n) {
                parents = new int[n];
                Arrays.fill(parents, -1);
            }

            public int find(int x) {
                if (parents[x] == -1) {
                    parents[x] = x;
                }
                while (x != parents[x]) {
                    x = parents[x];
                }
                return x;
            }

            public void Union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot != yRoot) {
                    parents[xRoot] = yRoot;
                }
            }

            public int getUnionCount() {
                int count = 0;
                for (int i = 0; i < parents.length; i++) {
                    if (parents[i] == i) {
                        count++;
                    }
                }
                return count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}