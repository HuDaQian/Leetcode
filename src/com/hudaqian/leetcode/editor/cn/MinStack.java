//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 759 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    public static void main(String[] args) {
//            MinStack minStack = new MinStack();
    }

    //  提交的时候 注意替换一下类的名字
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 解法2：不使用辅助栈来处理
     * 思路是栈中保存入栈值和最小值的差值
     * 出栈的时候 如果栈中保存的值小于0，那么表示之前的最小值要大于当前最小值
     * 这时 通过差值更新下最小值
     * 可以理解为把栈分成几段 每段开始的地方 都是之后最小值和之前最小值的差
     * 每段中间的部分 就是入栈值和当前段的最小值的差
     */
//    class MinStack {
//        Deque<Long> xStack;
//        Integer minValue;
//        public MinStack() {
//            xStack = new LinkedList<>();
//            minValue = Integer.MAX_VALUE;
//        }
//        public void push(int x) {
//            if (xStack.isEmpty()) {
//                xStack.push(0L);
//                minValue = x;
//            } else {
//                xStack.push((long) x - minValue);
//                minValue = Math.min(minValue, x);
//            }
//        }
//
//        public void pop() {
//            long diff = xStack.pop();
//            if (diff < 0) {
//                //  这里抛出 minValue
//                minValue = (int)(minValue-diff);
////            } else {
//                //  这里抛出 minValue+diff
//            }
//        }
//
//        public int top() {
//            Long diff = xStack.peek();
//            if (diff < 0) {
//                return minValue;
//            } else {
//                return (int)(minValue+diff);
//            }
//        }
//
//        public int getMin() {
//            return minValue;
//        }
//
//    }
//    class MinStack {
    class MinStackQuestion {
        //  原数据栈
        Deque<Integer> xStack;
        //  辅助栈
        //  栈里记录前N个数字最小的是啥
        Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStackQuestion() {
//        public MinStack() {
            xStack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.poll();
            minStack.poll();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}