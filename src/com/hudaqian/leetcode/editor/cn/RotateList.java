//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针 
// 👍 370 👎 0


package com.hudaqian.leetcode.editor.cn;

public class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5)))));
        System.out.print(solution.rotateRight(head, 2));
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
        public ListNode rotateRight(ListNode head, int k) {
//            /**
//             * 双指针 快指针先走k步 慢指针随后 开始一步一步走 快指针的next为空的时候 慢指针正好到尾部位置
//             */
//            if (head == null) {
//                return null;
//            }
//            ListNode slow = head;
//            ListNode fast = head;
//            //  统计链表长度 然后求余 省去多余操作
//            int count = 0;
//            while (k > 0) {
//                count++;
//                fast = fast.next;
//                k--;
//                if (fast == null) {
//                    k %= count;
//                    fast = head;
//                }
//            }
//            while (fast.next != null) {
//                slow = slow.next;
//                fast = fast.next;
//            }
//            fast.next = head;
//            head = slow.next;
//            slow.next = null;
//            return head;
            /**
             * 形成闭环 再断开
             */
            if (head == null || head.next == null) {
                return head;
            }
            ListNode ptr = head;
            int count = 1;
            while (ptr.next != null) {
                count++;
                ptr = ptr.next;
            }
            //  结成环
            ptr.next = head;
            ptr = head;
            /**
             * 这里第一个减1 是指链表中节点索引
             * 比如 [1, 2, 3, 4, 5] k=2
             * count = 5
             * 就是从倒数第二个节点的前一个节点断开
             * （count-1）表示最后一个节点
             * 再减k%count 表示向前移动n圈多了k%count步
             */
            int index = count - k%count - 1;
            //  index 为3
            while (index > 0) {
                ptr = ptr.next;
                index--;
            }
            head = ptr.next;
            ptr.next = null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}