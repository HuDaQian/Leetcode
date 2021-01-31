//如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。 
//
//
// 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "t
//ars"，"rats"，或 "arts" 相似。 
//
// 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同
//一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。 
//
// 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？ 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["tars","rats","arts","star"]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：strs = ["omv","ovm"]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 100 
// 1 <= strs[i].length <= 1000 
// sum(strs[i].length) <= 2 * 104 
// strs[i] 只包含小写字母。 
// strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。 
// 
//
// 
//
// 备注： 
//
// 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。 
// Related Topics 深度优先搜索 并查集 图 
// 👍 67 👎 0


package com.hudaqian.leetcode.editor.cn;
public class SimilarStringGroups {
    public static void main(String[] args) {
        Solution solution = new SimilarStringGroups().new Solution();
        String[] strs = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
        System.out.print(solution.numSimilarGroups(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSimilarGroups(String[] strs) {
            if (strs == null || strs.length == 0) return 0;
            int leng = strs.length;
            UnionFind unionFind = new UnionFind(leng);
            for (int i = 1; i < leng; i++) {
                for (int j = i-1; j >= 0; j--) {
                    if (isSimilar(strs[j], strs[i])) {
                        System.out.printf("%d - %d\n",i,j);
                        unionFind.union(i,j);
                        //  注意这里不能直接break 因为会出现 x和y相似 x和z相似 但是y和z不相似的情况
                        //  可以参考上边的示例
//                        break;
                    }
                }
            }
            return unionFind.res;
        }
        private boolean isSimilar(String s, String t) {
            if (s.equals(t)) return true;
            if (s.length() != t.length()) return false;
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            int len = tChars.length;
            int fir = -1,sec = -1;
            for (int i = 0; i < len; i++) {
                if (sChars[i] != tChars[i]) {
                    if (fir == -1) {
                        fir = i;
                    } else if (sec == -1) {
                        sec = i;
                    } else {
                        return false;
                    }
                }
            }
            return (fir != -1 && sec != -1)&&(sChars[fir] == tChars[sec]) && (sChars[sec] == tChars[fir]);
        }

        private class UnionFind {
            int[] parents;
            int[] size;
            int res;
            public UnionFind(int n) {
                this.parents = new int[n];
                this.size = new int[n];
                res = n;
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                    size[i] = 1;
                    res = n;
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
                    res--;
                    if (size[xRoot] > size[yRoot]) {
                        parents[yRoot] = xRoot;
                        size[xRoot] += size[yRoot];
                    } else  {
                        parents[xRoot] = yRoot;
                        size[yRoot] += size[xRoot];
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}