//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 
// 👍 809 👎 0


package com.hudaqian.leetcode.editor.cn;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int rob(TreeNode root) {
            //  解法1 暴力解法    超时
//            if (root == null) return 0;
//            int money = root.val;
//            if (root.left != null) {
//                money += (rob(root.left.left) + rob(root.left.right));
//            }
//            if (root.right != null) {
//                money += (rob(root.right.left) + rob(root.right.right));
//            }
//            return Math.max(money, rob(root.left) + rob(root.right));
            //  解法2 哈希映射缓存已经处理过的记录 注意递归函数 这里是rob函数重载，注意map参数的传递
//            Map<TreeNode, Integer> map = new HashMap<>();
//            return rob(root, map);
            //  解法3 官解 双哈希映射  f表示取当前节点的值的最大值  g表示不取当前节点的值的最大值（左边节点能取到的最大值 加上右边节点能取到的最大值）
            //  等查Bug
            //  转移方程 f(root) = root.val + g(root.left) + g(root.right)
            //  g(root) = Math.max(f(root.left), g(root.left)) + Math.max(f(root.right), g(root.right))
//            Map<TreeNode, Integer> f = new HashMap<>();
//            Map<TreeNode, Integer> g = new HashMap<>();
//            rob(root, f, g);
//            return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
            //  解法4 官解的空间压缩版本 因为只关注子节点以及自身节点 所以两个参数用来传递即可
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        private int[] dfs(TreeNode root) {
            if (root == null) return new int[2];
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int[] result = new int[2];
            result[0] = root.val + left[1] + right[1];
            result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return result;
        }

        private void rob(TreeNode root, Map<TreeNode, Integer> f, Map<TreeNode, Integer> g) {
            if (root == null) return;
            rob(root.left, f, g);
            rob(root.right, f, g);
            f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
            g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0))));
        }


        private int rob(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null) return 0;
            if (map.containsKey(root)) return map.get(root);

            int money = root.val;
            if (root.left != null) {
                money += (rob(root.left.left, map) + rob(root.left.right, map));
            }
            if (root.right != null) {
                money += (rob(root.right.left, map) + rob(root.right.right, map));
            }
            int res = Math.max(money, rob(root.left, map) + rob(root.right, map));
            map.put(root, res);
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}