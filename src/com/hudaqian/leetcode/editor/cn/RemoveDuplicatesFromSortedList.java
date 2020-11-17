//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 427 👎 0


package com.hudaqian.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4))))));
        System.out.print(ListNode.print(solution.deleteDuplicates(head)));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode node) {
            val = x;
            next = node;
        }
        private static String print(ListNode head) {
            StringBuilder sb = new StringBuilder();
            ListNode current = head;
            while (current != null) {
                sb.append(current.val);
                sb.append(" ");
                current = current.next;
            }
            return sb.toString();
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null) {
                if (slow.val == fast.val) {
                    slow.next = fast.next;
                } else {
                    slow = slow.next;
                }
                fast = fast.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}