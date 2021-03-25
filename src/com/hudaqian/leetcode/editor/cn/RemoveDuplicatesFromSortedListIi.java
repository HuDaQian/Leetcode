//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 
// 👍 515 👎 0


package com.hudaqian.leetcode.editor.cn;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4, new ListNode(5)))))));
        System.out.print(solution.deleteDuplicates(head));
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
    }


    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode prev = new ListNode(-101, head);
            ListNode dummy = prev;

            ListNode ptr = head;
            ListNode current = head.next;
            Boolean isDuplicate = false;
            while (current != null) {
                if (current.val == ptr.val) {
                    isDuplicate = true;
                    current = current.next;
                } else {
                    if (!isDuplicate) {
                        prev.next = ptr;
                        prev = prev.next;
                    } else {
                        isDuplicate = false;
                    }
                    ptr = current;
                    current = current.next;
                }
            }
            if (!isDuplicate) {
                prev.next = ptr;
                prev = prev.next;
            }
            prev.next = null;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}