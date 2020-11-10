//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1327 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String print(ListNode listNode) {
            StringBuilder sb = new StringBuilder();
            while (listNode != null) {
                sb.append(listNode.val);
                listNode = listNode.next;
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
        public ListNode reverseList(ListNode head) {
            /**
             * 解法1：迭代
             * 相当于连续两个节点 局部变量保存后一个节点的next节点
             * 然后调整后一个节点的next节点为前一个节点
             * 然后调整变量为后一个节点和局部变量所指向的节点
             */
//            ListNode prev = null;
//            ListNode current = head;
//            while (current != null) {
//                ListNode newNode = current.next;
//                current.next = prev;
//                prev = current;
//                current = newNode;
//            }
//            return prev;
            /**
             * 解法2：双指针改
             * 1-2-3-4-5
             * 2-1-3-4-5
             * 3-2-1-4-5
             * 4-3-2-1-5
             * 5-4-3-2-1
             */
            if (head == null) return null;
            ListNode current = head;
            while (head.next != null) {
                ListNode tempNode = head.next.next;
                head.next.next = current;
                current = head.next;
                head.next = tempNode;
            }
            return current;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}