//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表 
// 👍 184 👎 0


package com.hudaqian.leetcode.editor.cn;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new DesignLinkedList().new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode prev;

        DoubleNode(int val) {
            this.val = val;
        }
    }
    class MyLinkedList {
        int size;
        DoubleNode head, tail;

        public MyLinkedList() {
            size = 0;
            head = new DoubleNode(0);
            tail = new DoubleNode(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            DoubleNode current = head;
            //  调整一下  如果index>size/2 那么从后边开始搜索
            if (index > size / 2) {
                current = tail;
                //  结尾开始
                while (index < size) {
                    current = current.prev;
                    index++;
                }
            } else {
                while (index >= 0) {
                    current = current.next;
                    index--;
                }
            }

            return current.val;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index < 0) index = 0;
            DoubleNode temp = head;
            if (index > size / 2) {
                //  从后往前搜索 这次是搜索前一个结点 在其之后插入 所以多走一步
                temp = tail;
                while (index <= size) {
                    temp = temp.prev;
                    index++;
                }
            } else {
                while (index > 0) {
                    temp = temp.next;
                    index--;
                }
            }
            size++;
            DoubleNode newNode = new DoubleNode(val);
            DoubleNode backNode = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = backNode;
            backNode.prev = newNode;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index > size - 1) return;
            DoubleNode temp = head;
            if (index > size / 2) {
                //  从后往前搜索
                temp = tail;
                while (index < size) {
                    temp = temp.prev;
                    index++;
                }
            } else {
                while (index >= 0) {
                    temp = temp.next;
                    index--;
                }
            }
            size--;
            DoubleNode foreNode = temp.prev;
            DoubleNode backNode = temp.next;
            foreNode.next = backNode;
            backNode.prev = foreNode;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}