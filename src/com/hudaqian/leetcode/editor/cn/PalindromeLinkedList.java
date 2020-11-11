//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 757 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
        public static void main(String[] args) {
            Solution solution = new PalindromeLinkedList().new Solution();
            ListNode head = new ListNode(-129);
            head.next = new ListNode(-129);
            System.out.println(solution.isPalindrome(head));
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
    public boolean isPalindrome(ListNode head) {
        /**
         * 解法1：复制到数组 然后双指针处理
         */
//        List<Integer> vals = new ArrayList<Integer>();
//        ListNode currentNode = head;
//        while (currentNode != null) {
//            vals.add(currentNode.val);
//            currentNode = currentNode.next;
//        }
//        int first = 0,second = vals.size()-1;
//        while (first < second) {
//            if (!vals.get(first).equals(vals.get(second))) {
//                return false;
//            }
//            first++;
//            second--;
//        }
//        return true;
        /**
         * 解法2：快慢指针
         * 反转后半段链表
         * 比较完成之后反转后半段链表还原
         */
//        if (head == null) {
//            return true;
//        }
//        ListNode firstNode = endOfHalfPalindrome(head);
//        ListNode secondNode = reverseLinkedList(firstNode.next);
//
//        boolean result = true;
//        ListNode frontNode = head;
//        ListNode backgroundNode = secondNode;
//        while (backgroundNode != null) {
//            if (frontNode.val != backgroundNode.val) {
//                result = false;
//                break;
//            }
//            frontNode = frontNode.next;
//            backgroundNode = backgroundNode.next;
//        }
//        firstNode.next = reverseLinkedList(secondNode);
//        return result;
        /**
         * 解法3：快慢指针过程中 直接反转前半段链表
         * 比较完成之后再反转回去
         */
        if (head == null) {
            return true;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            fast = fast.next.next;
            slow = temp;
        }
        if(fast != null) slow = slow.next;
        while(slow != null){
            if(slow.val != pre.val) return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
    /**
     * 方法1：找寻链表中间节点 返回中间节点前节点
     */
    private ListNode endOfHalfPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    /**
     * 方法2：反转链表
     */
    private ListNode reverseLinkedList(ListNode head) {
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