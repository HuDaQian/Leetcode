//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
// 说明：不允许修改给定的链表。
//
// 进阶：
//
//
// 你是否可以使用 O(1) 空间解决此题？
//
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
// 示例 3：
//
//
//
//
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围在范围 [0, 104] 内
// -105 <= Node.val <= 105
// pos 的值为 -1 或者链表中的一个有效索引
//
// Related Topics 链表 双指针
// 👍 752 👎 0


package com.hudaqian.leetcode.editor.cn;

public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        ListNode head = new ListNode(3);
        ListNode cycle = new ListNode(2);
        head.next = cycle;
        ListNode thrNode = new ListNode(0);
        ListNode forNode = new ListNode(-4);
        cycle.next = thrNode;
        thrNode.next = forNode;
        forNode.next = cycle;
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
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            /**
             * 快慢指针 同时从起点出发 慢指针一次移动一格 快指针一次移动两格
             * 当两指针相遇的时候
             * 设定从起点到入环点距离为a
             * 从入环点到相遇点距离为b
             * 从相遇点到入环点距离为c
             * 相遇的时候快指针已经绕环了n周
             * 那么 快指针移动的距离为 a + n (b+c) + b
             * 慢指针移动的距离为 a + b
             * a + (n + 1) b + nc = 2(a + b)
             * a = (n + 1) b + nc - 2b = c + (n-1)(b+c)
             * 此时再设定一个指针ptr从起点出发 slow往前一格 ptr往前一格
             * 当两者相遇的时候 所在的指针即为入环点
             */
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null) {
                if (fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        slow = slow.next;
                        ptr = ptr.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}