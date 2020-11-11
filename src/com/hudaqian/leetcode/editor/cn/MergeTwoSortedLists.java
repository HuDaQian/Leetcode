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
//        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
//        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode l1 = null;
        ListNode l2 = null;
        System.out.print(ListNode.print(solution.mergeTwoLists(l1, l2)));
    }

    private static class ListNode {
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

        private static String print(ListNode listNode) {
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
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            /**
             * 解法1：迭代
             */

            //        if (l1 == null) return l2;
            //        if (l2 == null) return l1;
            //        ListNode head = new ListNode(0);
            //        ListNode current = head;
            //        while (l1 != null && l2 != null) {
            //            boolean check = l1.val < l2.val;
            //            current.next = check ? l1 : l2;
            //            current = current.next;
            //            if (check) {
            //                l1 = l1.next;
            //            } else  {
            //                l2 = l2.next;
            //            }
            //        }
            //        current.next = (l1 == null) ? l2 : l1;
            //        return head.next;
            //        }
            /**
             * 解法2：递归
             */
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}