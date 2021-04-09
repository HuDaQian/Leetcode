//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 564 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//            postorder(root, list);
//            return list;
            //   前序遍历   根-左-右
            //   后序遍历   左-右-根
            //  所以将前序遍历调整下  右节点先入栈 然后左节点再入栈 数组中顺序为 根-右-左
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    list.add(node.val);
                    stack.push(node);
                    node = node.right;
                }
                node = stack.pop();
                node = node.left;
            }
            Collections.reverse(list);
            return list;
        }

        private void postorder(TreeNode node, List<Integer> list) {
            if (node == null) return;
            postorder(node.left, list);
            postorder(node.right, list);
            list.add(node.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}