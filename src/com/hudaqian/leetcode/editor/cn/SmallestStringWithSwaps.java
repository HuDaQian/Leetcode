//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 并查集 数组 
// 👍 102 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        Solution solution = new SmallestStringWithSwaps().new Solution();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        System.out.print(solution.smallestStringWithSwaps(s, pairs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            /**
             * 并查集 计算索引集合 看那几个索引可以联合在一起
             * 哈希映射 用来统计 每个索引集合对应那几个字符
             * 最后使用最小堆来排列对应的字符
             */
            if (s == null || s.length() == 0) return "";
            int len = s.length();
            UnionFind unionFind = new UnionFind(len);
            for (List<Integer> list : pairs) {
//                assert (list.size() < 2) : "参数错误";
                unionFind.union(list.get(0), list.get(1));
            }
            Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                Character c = s.charAt(i);
                int key = unionFind.find(i);
                PriorityQueue<Character> priorityQueue = map.get(key);
                if (priorityQueue == null) {
                    priorityQueue = new PriorityQueue<Character>();
                }
                priorityQueue.offer(c);
                map.put(key, priorityQueue);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                int key = unionFind.find(i);
                PriorityQueue<Character> priorityQueue = map.get(key);
                if (!priorityQueue.isEmpty()) {
                    Character c = priorityQueue.poll();
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        private class UnionFind {
            private final int[] parents;
            private final int[] rank;

            public UnionFind(int n) {
                this.parents = new int[n];
                this.rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                    rank[i] = 1;
                }
            }

            public int find(int x) {
//                assert (x < 0 || x == parents.length) : "输入参数超过范围";
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
                    } else if (rank[yRoot] > rank[xRoot]) {
                        parents[xRoot] = yRoot;
                    } else {
                        parents[xRoot] = yRoot;
                        rank[yRoot]++;
                    }
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