//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 345 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.List;

public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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
        public ListNode partition(ListNode head, int x) {
            /**
             * 两个链表记录大于target值的 和小于target值的
             */
//            ListNode upNodeS = new ListNode(0);
//            ListNode upNode = upNodeS;
//            ListNode downNodeS = new ListNode(0);
//            ListNode downNode = downNodeS;
//            ListNode current = head;
//            while (current != null) {
//                if (current.val >= x) {
//                    upNode.next = current;
//                    upNode = upNode.next;
//                } else {
//                    downNode.next = current;
//                    downNode = downNode.next;
//                }
//                current = current.next;
//                upNode.next = null;
//                downNode.next = null;
//            }
//            downNode.next = upNodeS.next;
//            return downNodeS.next;
            /**
             * 双指针
             */
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            while (fast.next != null) {
                /**
                 * 如果fast指向的结点val小于target 那么将它移动到slow的位置
                 */
                if (fast.next.val < x) {
                    if (slow.next != fast.next) {
                        ListNode tempNode = fast.next;
                        fast.next = fast.next.next;
                        tempNode.next = slow.next;
                        slow.next = tempNode;
                        slow = slow.next;
                    } else {
                        slow = slow.next;
                        fast = fast.next;
                    }
                } else {
                    fast = fast.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}