//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 319 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();

    }

    private class TreeNode {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            /**
             * 广度优先遍历
             */
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) return list;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            Boolean isLeftToRight = false;
            while (!queue.isEmpty()) {
                Deque<Integer> levelList = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curNode = queue.poll();
                    if (isLeftToRight) {
                        levelList.offerFirst(curNode.val);
                    } else {
                        levelList.offerLast(curNode.val);
                    }
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
                list.add(new LinkedList<>(levelList));
                isLeftToRight = !isLeftToRight;
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}