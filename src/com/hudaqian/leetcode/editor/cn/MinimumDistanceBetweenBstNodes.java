//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 100] 内 
// 0 <= Node.val <= 105 
// 
// 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 131 👎 0


package com.hudaqian.leetcode.editor.cn;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
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
        public int minDiffInBST(TreeNode root) {
            //  隐含条件：二叉搜索树
            //  1、相邻节点的差值绝对比相隔节点的差值小
            //  2、中序遍历得到的结果是递增数列
            if (root == null) return 0;
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < list.size()-1; i++) {
                res = Math.min(Math.abs(list.get(i+1) - list.get(i)), res);
            }
            return res;
        }
        private void dfs(TreeNode root, List<Integer> list) {
            if (root == null) return;
            dfs(root.left, list);
            list.add(root.val);
            dfs(root.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}