//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 481 👎 0


    package com.hudaqian.leetcode.editor.cn;
    public class RemoveLinkedListElements {
        public static void main(String[] args) {
            Solution solution = new RemoveLinkedListElements().new Solution();
            System.out.print(solution.removeElements(null, 1));
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
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        /**
         * 递归解法
         */
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            head = removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }