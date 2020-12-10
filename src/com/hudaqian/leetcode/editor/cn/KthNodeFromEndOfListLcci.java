//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 49 👎 0


package com.hudaqian.leetcode.editor.cn;

public class KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int kthToLast(ListNode head, int k) {
            /**
             * 双指针 快指针先走k步 然后快慢一起走 快指针走到头的时候 慢指针正好是倒数第k个元素
             */
            ListNode fast  = head,slow = head;
            while (k > 1) {
                fast = fast.next;
                k--;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}