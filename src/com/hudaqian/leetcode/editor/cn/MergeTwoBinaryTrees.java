//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 598 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            /**
             * 深度优先搜索
             */
//            if (t1 == null) return t2;
//            if (t2 == null) return t1;
//            TreeNode newNode = new TreeNode(t1.val + t2.val);
//            TreeNode leftNode = mergeTrees(t1.left, t2.left);
//            TreeNode rightNode = mergeTrees(t1.right, t2.right);
//            newNode.left = leftNode;
//            newNode.right = rightNode;
//            return newNode;
            /**
             * 广度优先搜索
             * 借用队列这种结构迭代计算每层的结果 相当于层级遍历
             */
            if (t1 == null) return t2;
            if (t2 == null) return t1;
            Queue<TreeNode> mainQueue = new LinkedList<>();
            Queue<TreeNode> t1Queue = new LinkedList<>();
            Queue<TreeNode> t2Queue = new LinkedList<>();
            TreeNode newNode = new TreeNode(t1.val + t2.val);
            mainQueue.offer(newNode);
            t1Queue.offer(t1);
            t2Queue.offer(t2);
            while (!t1Queue.isEmpty() && !t2Queue.isEmpty()) {
                TreeNode node1 = t1Queue.poll(), node2 = t2Queue.poll(), mainNode = mainQueue.poll();
                TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
                if (left1 != null && left2 != null) {
                    TreeNode leftNode = new TreeNode(left1.val + left2.val);
                    mainNode.left = leftNode;
                    mainQueue.offer(leftNode);
                    t1Queue.offer(left1);
                    t2Queue.offer(left2);
                    //  终止向下查询
                } else if (left1 == null) {
                    mainNode.left = left2;
                } else {
                    mainNode.left = left1;
                }
                if (right1 != null && right2 != null) {
                    TreeNode rightNode = new TreeNode(right1.val + right2.val);
                    mainNode.right = rightNode;
                    mainQueue.offer(rightNode);
                    t1Queue.offer(right1);
                    t2Queue.offer(right2);
                    //  终止向下查找
                } else if (right1 == null) {
                    mainNode.right = right2;
                } else {
                    mainNode.right = right1;
                }
            }
            return newNode;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}