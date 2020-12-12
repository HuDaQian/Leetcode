//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 144 👎 0


package com.hudaqian.leetcode.editor.cn;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();

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
        public ListNode reverseList(ListNode head) {
//            ListNode prev = null;
//            ListNode current = head;
//            while (current != null) {
//                ListNode tempNode = current.next;
//                current.next = prev;
//                prev = current;
//                current = tempNode;
//            }
//            return prev;
            /**
             * 迭代优化
             * 1-2-3-4-5
             * 2-1-3-4-5
             * 3-2-1-4-5
             * 4-3-2-1-5
             * 5-4-3-2-1
             * 思路是 使用head这个指针
             */
//            ListNode current = head;
//            if (head == null) return head;
//            // head这个指针不能动
//            while (head.next != null) {
//                ListNode tempNode = head.next;
//                head.next = head.next.next;
//                tempNode.next = current;
//                current = tempNode;
//            }
//            return current;
            /**
             * 递归
             */
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tempNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return tempNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}