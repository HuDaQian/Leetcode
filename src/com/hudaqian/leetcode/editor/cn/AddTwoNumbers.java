//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4943 👎 0


package com.hudaqian.leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l1_s = l1;
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);
        ListNode l2_s = l2;

        System.out.print(ListNode.print(solution.addTwoNumbers(l1_s, l2_s)) + '\n');
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static String print(ListNode listNode) {
            StringBuilder sb = new StringBuilder();
            while (listNode != null) {
                sb.append(listNode.val);
                listNode = listNode.next;
            }
            return sb.toString();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            /**
             * 倒着计算
             * 当前链表的数字+前节点数字的和是否超过十
             */
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int dlg = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
                int value = dlg % 10;
                carry = dlg / 10;
                current.next = new ListNode(value);
                current = current.next;
                l1 = (l1 == null) ? l1 : l1.next;
                l2 = (l2 == null) ? l2 : l2.next;
            }
            if (carry != 0) current.next = new ListNode(carry);
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}