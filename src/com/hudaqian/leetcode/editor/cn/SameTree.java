//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 542 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            /**
             * 深度优先搜索 DFS
             * 递归查找
             */
//            if (p == null && q == null) return true;
//            if (p == null || q == null) return false;
//            if (p.val == q.val) {
//                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//            }
//            return false;
            /**
             * 广度优先搜索 BFS
             * 迭代查找
             */
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();
            queue1.offer(p);
            queue2.offer(q);
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1.val != node2.val) return false;
                TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
                if (left1==null ^ left2==null) return false;
                if (right1==null ^ right2==null) return false;
                if (left1 != null) queue1.offer(left1);
                if (left2 != null) queue2.offer(left2);
                if (right1 != null) queue1.offer(right1);
                if (right2 != null) queue2.offer(right2);
            }
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}