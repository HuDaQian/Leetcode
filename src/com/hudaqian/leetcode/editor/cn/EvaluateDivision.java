//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values
//[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。 
//
// 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], quer
//ies = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a
//","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
// Related Topics 并查集 图 
// 👍 302 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        System.out.print(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int equationLen = equations.size();
            UnionFind unionFind = new UnionFind(2 * equationLen);
            Map<String, Integer> map = new HashMap<>();
            int ptr = 0;
            for (int i = 0; i < equationLen; i++) {
                List<String> equation = equations.get(i);
                String var1 = equation.get(0);
                String var2 = equation.get(1);

                if (!map.containsKey(var1)) {
                    map.put(var1, ptr);
                    ptr++;
                }
                if (!map.containsKey(var2)) {
                    map.put(var2, ptr);
                    ptr++;
                }
                unionFind.union(map.get(var1), map.get(var2), values[i]);
            }
            int queriesLen = queries.size();
            double[] res = new double[queriesLen];
            for (int i = 0; i < queriesLen; i++) {
                List<String> query = queries.get(i);
                String var1 = query.get(0);
                String var2 = query.get(1);

                Integer id1 = map.get(var1);
                Integer id2 = map.get(var2);

                if (id1 == null || id2 == null) {
                    res[i] = -1.0d;
                } else {
                    res[i] = unionFind.isConnected(id1, id2);
                }
            }
            return res;
        }
    }

    class UnionFind {
        //  树
        int[] parents;
        //  权
        double[] weights;
        //  秩
        int[] size;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.weights = new double[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                weights[i] = 1.0d;
                size[i] = 1;
            }
        }

        /**
         * 这里需要使用递归 来更新权的值
         */
        public int find(int x) {
//            assert (x<0 || x >= parents.length);
            if (x != parents[x]) {
                int origin = parents[x];
                parents[x] = find(parents[x]);
                weights[x] *= weights[origin];
            }
            return parents[x];
        }

        public void union(int x, int y, double value) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                if (size[xRoot] > size[yRoot]) {
                    parents[yRoot] = xRoot;
                    size[xRoot] += size[yRoot];
                    //  weights[xRoot] = 1
                    //  weights[yRoot = 1
                    //  weights[x] = m
                    //  weights[y] = n
                    //  value = m / n
                    //  合并以后
                    //  weights[xRoot] = 1
                    //  weights[x] = m
                    //  weights[y] = m / value
                    //  weights[yRoot] =  m / (value*n)
                    weights[yRoot] = weights[x]  / (weights[y] * value);
                } else {
                    parents[xRoot] = yRoot;
                    size[yRoot] += size[xRoot];
                    //  weights[xRoot] = 1
                    //  weights[yRoot = 1
                    //  weights[x] = m
                    //  weights[y] = n
                    //  value = x / y
                    //  合并以后
                    //  weights[yRoot] = 1
                    //  weights[y] = n
                    //  weights[x] = n * value
                    //  weights[xRoot] = (value*n) / m
                    weights[xRoot] = weights[y] * value / weights[x];
                }
            }
        }

        public double isConnected(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return weights[x] / weights[y];
            } else {
                return -1.0d;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}