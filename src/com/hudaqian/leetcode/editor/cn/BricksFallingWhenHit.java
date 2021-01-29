//有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
//
//
// 一块砖直接连接到网格的顶部，或者
// 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
//
//
// 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消
//失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
//
// 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
//
// 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
//
//
//
// 示例 1：
//
//
//输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
//输出：[2]
//解释：
//网格开始为：
//[[1,0,0,0]，
// [1,1,1,0]]
//消除 (1,0) 处加粗的砖块，得到网格：
//[[1,0,0,0]
// [0,1,1,0]]
//两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
//[[1,0,0,0],
// [0,0,0,0]]
//因此，结果为 [2] 。
//
//
// 示例 2：
//
//
//输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
//输出：[0,0]
//解释：
//网格开始为：
//[[1,0,0,0],
// [1,1,0,0]]
//消除 (1,1) 处加粗的砖块，得到网格：
//[[1,0,0,0],
// [1,0,0,0]]
//剩下的砖都很稳定，所以不会掉落。网格保持不变：
//[[1,0,0,0],
// [1,0,0,0]]
//接下来消除 (1,0) 处加粗的砖块，得到网格：
//[[1,0,0,0],
// [0,0,0,0]]
//剩下的砖块仍然是稳定的，所以不会有砖块掉落。
//因此，结果为 [0,0] 。
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// grid[i][j] 为 0 或 1
// 1 <= hits.length <= 4 * 104
// hits[i].length == 2
// 0 <= xi <= m - 1
// 0 <= yi <= n - 1
// 所有 (xi, yi) 互不相同
//
// Related Topics 并查集
// 👍 158 👎 0


package com.hudaqian.leetcode.editor.cn;

public class BricksFallingWhenHit {
    public static void main(String[] args) {
        Solution solution = new BricksFallingWhenHit().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] hitBricks(int[][] grid, int[][] hits) {

            int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            int r = grid.length;
            int l = grid[0].length;
            int[][] copy = new int[r][l];
            for (int i = 0; i < r; i++) {//复制了一个grid数组
                for (int j = 0; j < l; j++) {
                    copy[i][j] = grid[i][j];
                }
            }

            for (int[] hit : hits) {//把将要敲碎的砖块先置为0（此时copy里砖头是除了敲碎的之外所有的，包括稳定的和不稳定的）
                copy[hit[0]][hit[1]] = 0;
            }
            int size = r * l;
            UnionFind unionFind = new UnionFind(size + 1);//初始化并查集（这里加1是处理了天花板，parent[size]指代了天花板）
            for (int j = 0; j < l; j++) {
                if (copy[0][j] == 1) {//先处理第一排砖块，这一排的都挨着天花板，所以和size相连
                    unionFind.union(j, size);
                }
            }

            for (int i = 1; i < r; i++) {//不挨着天花板的，类似动态规划处理，上头有砖头，就跟上头连，左边有就跟左边连
                for (int j = 0; j < l; j++) {
                    if (copy[i][j] == 1) {//前提是当前这一块得有砖头
                        if (copy[i - 1][j] == 1) {//上头有砖头，和上头union
                            unionFind.union(i * l + j, (i - 1) * l + j);//这里union的参数，其实就是第几块砖头
                        }
                        if (j > 0 && copy[i][j - 1] == 1) {//这里j需要先大于0
                            unionFind.union(i * l + j, i * l + j - 1);
                        }
                    }
                }
            }
            int hitsLen = hits.length;
            int[] ans = new int[hitsLen];//终于，初始化结果数组
            for (int i = hitsLen - 1; i >= 0; i--) {//从最后一块被敲碎的砖头开始，往上加
                int x = hits[i][0];
                int y = hits[i][1];

                if (grid[x][y] == 0) {//这里的意思是，锤子敲的地方本身就没有砖头，这时候，ans[i]就是0
                    continue;
                }

                int currentSize = unionFind.getSize(size);//记录一下，补这一块砖头之前，当前有多少稳定的砖头
                if (x == 0) {//如果补的这一块挨着天花板，先连上
                    unionFind.union(y, size);
                }
                for (int[] direction : DIRECTIONS) {//上下左右，看一看，有砖头就连上
                    int nx = x + direction[0];
                    int ny = y + direction[1];
                    if ((nx >= 0 && ny >= 0 && nx < r && ny < l) && copy[nx][ny] == 1) {
                        unionFind.union(x * l + y, nx * l + ny);//**无论上下左右是什么状况，连起来就行了，我认为这一步最能体现到并查集的优势了。**
                    }
                }
                int currentSize2 = unionFind.getSize(size);//连完了之后，再看看有多少连着天花板
                copy[x][y] = 1;//把这一块砖头补上
                ans[i] = Math.max(0, currentSize2 - currentSize - 1);//减一是因为要把补的这一块减去。而有可能两个currentSize的大小是一致的，也就是加上这一块，稳定砖头的数目没有发生变化，此时，ans[i]显然又不能等于-1，应该等于0，因此max一下

            }
            return ans;

        }


        //并查集
        private class UnionFind {
            int[] parent;
            int[] size;

            public UnionFind(int n) {
                parent = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }


            //找到砖头，这里用到了路径缩短，没有更新size
            public int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            //注意getSize要先find一下，毕竟此时x可能不等于parent[x]
            public int getSize(int n) {
                int root = find(n);
                return size[root];
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return;
                }
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}