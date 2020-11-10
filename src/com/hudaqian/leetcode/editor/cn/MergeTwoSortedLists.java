//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1369 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.List;

public class MergeTwoSortedLists {
        public static void main(String[] args) {
            Solution solution = new MergeTwoSortedLists().new Solution();

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
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            boolean check = l1.val < l2.val;
            current.next = check ? l1 : l2;
            current = current.next;
            if (check) {
                l1 = l1.next;
            } else  {
                l2 = l2.next;
            }
        }
        current.next = (l1 == null) ? l2 : l1;
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }