//在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。 
//
// 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两
//个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。 
//
// 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？ 
//
// 
//
// 示例 1: 
//
// 
//输入: [[0,2],[1,3]]
//输出: 3
//解释:
//时间为0时，你位于坐标方格的位置为 (0, 0)。
//此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
//
//等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
// 
//
// 示例2: 
//
// 
//输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6
//]]
//输出: 16
//解释:
// 0  1  2  3  4
//24 23 22 21  5
//12 13 14 15 16
//11 17 18 19 20
//10  9  8  7  6
//
//最终的路线用加粗进行了标记。
//我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
// 
//
// 
//
// 提示: 
//
// 
// 2 <= N <= 50. 
// grid[i][j] 是 [0, ..., N*N - 1] 的排列。 
// 
// Related Topics 堆 深度优先搜索 并查集 二分查找 
// 👍 136 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class SwimInRisingWater {
    public static void main(String[] args) {
        Solution solution = new SwimInRisingWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int swimInWater(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
            int ans = 0;
            int rows = grid.length, cols = grid[0].length;
            UnionFind unionFind = new UnionFind(rows*cols);
//            int[] temp = new int[rows*cols];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int num = grid[i][j];
                    List<Integer> tempList = map.getOrDefault(num, new ArrayList<>());
                    tempList.add(i*cols+j);
                    map.put(num, tempList);
                }
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            for (int num : list) {
                ans = num;
                //  从map中获取
                List<Integer> positions = map.get(num);
                for (int position : positions) {
                    //  获取上下左右四个方向的数字 如果小于num 那么加入并查集
                    int[] p = new int[2];
                    p[0] = position/cols;
                    p[1] = position%cols;
                    for (int[] dir:direction) {
                        int[] t = new int[2];
                        t[0] = p[0]+dir[0];
                        t[1] = p[1]+dir[1];
                        if (t[0]<0 || t[1]<0 || t[0]>=cols || t[1] >= cols) {
                            continue;
                        }
                        int tNum = grid[t[0]][t[1]];
                        if (tNum <= num) {
                            unionFind.union(position, t[0]*cols+t[1]);
                        }
                    }
                }
                if (unionFind.find(0) == unionFind.find(cols*rows-1)) {
                    break;
                }
            }
            return ans;
        }
        private class UnionFind {
            int[] parents;
            int[] size;
            public UnionFind(int n) {
                this.parents = new int[n];
                this.size = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                    size[i] = 1;
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
                    if (size[xRoot] > size[yRoot]) {
                        parents[yRoot] = xRoot;
                        size[xRoot] += size[yRoot];
                    } else {
                        parents[xRoot] = yRoot;
                        size[yRoot] += size[xRoot];
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}