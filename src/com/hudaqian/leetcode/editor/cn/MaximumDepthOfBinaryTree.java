//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 734 👎 0


package com.hudaqian.leetcode.editor.cn;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.print(solution.maxDepth(treeNode));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static String print(TreeNode treeNode) {
            // 使用层次遍历即可，需要一个Queue，
            // 定义一个列表存储出队元素
            ArrayList<Integer> list = new ArrayList<Integer>();
            Queue<TreeNode> qu = new LinkedList<TreeNode>();  // 初始化queue
            if (treeNode != null) {
                qu.add(treeNode); // 根节点入队
                while (!qu.isEmpty()) {
                    TreeNode t = qu.poll();  // 出队
                    list.add(t.val);
                    if (t.left != null) {
                        qu.add(t.left);
                    }
                    if (t.right != null) {
                        qu.add(t.right);
                    }
                }
            }
            return list.toString();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            /**
             * 解法1：递归
             */
            if (root == null) {
                return 0;
            } else {
                int leftDeepth = maxDepth(root.left);
                int rightDeepth = maxDepth(root.right);
                return Math.max(leftDeepth, rightDeepth) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}