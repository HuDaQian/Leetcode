//多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生
//成多级数据结构，如下面的示例所示。 
//
// 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
//输出：[1,2,3,7,8,11,12,9,10,4,5,6]
//解释：
//
//输入的多级列表如下图所示：
//
//
//
//扁平化后的链表如下图：
//
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2,null,3]
//输出：[1,3,2]
//解释：
//
//输入的多级列表如下图所示：
//
//  1---2---NULL
//  |
//  3---NULL
// 
//
// 示例 3： 
//
// 输入：head = []
//输出：[]
// 
//
// 
//
// 如何表示测试用例中的多级链表？ 
//
// 以 示例 1 为例： 
//
//  1---2---3---4---5---6--NULL
//         |
//         7---8---9---10--NULL
//             |
//             11--12--NULL 
//
// 序列化其中的每一级之后： 
//
// [1,2,3,4,5,6,null]
//[7,8,9,10,null]
//[11,12,null]
// 
//
// 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。 
//
// [1,2,3,4,5,6,null]
//[null,null,7,8,9,10,null]
//[null,11,12,null]
// 
//
// 合并所有序列化结果，并去除末尾的 null 。 
//
// [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12] 
//
// 
//
// 提示： 
//
// 
// 节点数目不超过 1000 
// 1 <= Node.val <= 10^5 
// 
// Related Topics 深度优先搜索 链表 
// 👍 138 👎 0


package com.hudaqian.leetcode.editor.cn;

public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenAMultilevelDoublyLinkedList().new Solution();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.child = n2;
        n2.child = n3;
//        Node n4 = new Node(4);
//        Node n5 = new Node(5);
//        Node n6 = new Node(6);
//        Node n7 = new Node(7);
//        Node n8 = new Node(8);
//        Node n9 = new Node(9);
//        Node n10 = new Node(10);
//        Node n11 = new Node(11);
//        Node n12 = new Node(12);
//        //  第一级
//        n1.next = n2;
//        n2.prev = n1;
//        n2.next = n3;
//        n3.prev = n2;
//        n3.next = n4;
//        n4.prev = n3;
//        n4.next = n5;
//        n5.prev = n4;
//        n5.next = n6;
//        n6.prev = n5;
//        //  第二级
//        n3.child = n7;
//        n7.next = n8;
//        n8.prev = n7;
//        n8.next = n9;
//        n9.prev = n8;
//        n9.next = n10;
//        n10.prev = n9;
//        //  第三级
//        n8.child = n11;
//        n11.next = n12;
//        n12.prev = n11;
        System.out.print(solution.flatten(n1));
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    ;
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

    class Solution {
        public Node flatten(Node head) {
            if (head == null) {
                return null;
            }
            Node nextNode = flatten(head.next);
            Node sonNode = flatten(head.child);
            if (sonNode == null) {
                head.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = head;
                }
            } else {
                head.next = sonNode;
                sonNode.prev = head;
                while (sonNode.next != null) {
                    sonNode = sonNode.next;
                }
                sonNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = sonNode;
                }
                head.child = null;
            }
            return head;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}