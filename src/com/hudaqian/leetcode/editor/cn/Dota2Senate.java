//Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇) 
//
// Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议
//员都可以行使两项权利中的一项： 
//
// 
// 
// 禁止一名参议员的权利： 
//
// 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。 
// 
// 
// 宣布胜利： 
// 
// 
//
// 如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。 
//
// 
//
// 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符
//串的大小将是 n。 
//
// 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。 
//
// 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 
//Dire。 
//
// 
//
// 示例 1： 
//
// 
//输入："RD"
//输出："Radiant"
//解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，
//第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
// 
//
// 示例 2： 
//
// 
//输入："RDD"
//输出："Dire"
//解释：
//第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
//第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
//第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
//因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
// 
//
// 
//
// 提示： 
//
// 
// 给定字符串的长度在 [1, 10,000] 之间. 
// 
//
// 
// Related Topics 贪心算法 
// 👍 113 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public static void main(String[] args) {
        Solution solution = new Dota2Senate().new Solution();
        String senate = "DR";
        System.out.print(solution.predictPartyVictory(senate));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String predictPartyVictory(String senate) {
            /**
             * 贪心解法
             * 思路是 向后搜索反对派成员ban掉 如果搜索到尾部 那么从头开始搜索
             * 模拟双队列
             */
//            int len = senate.length();
//            Queue<Integer> radiant = new LinkedList<>();
//            Queue<Integer> dire = new LinkedList<>();
//            for (int i = 0; i < len; i++) {
//                if (senate.charAt(i) == 'R') {
//                    radiant.offer(i);
//                } else {
//                    dire.offer(i);
//                }
//            }
//            while (!radiant.isEmpty() && !dire.isEmpty()) {
//                int rIndex = radiant.poll(), dIndex = dire.poll();
//                if (rIndex < dIndex) {
//                    radiant.offer(rIndex + len);
//                } else {
//                    dire.offer(dIndex + len);
//                }
//            }
//            return radiant.isEmpty() ? "Dire" : "Radiant";
            /**
             * 数组记录淘汰状态 搜索不到需要淘汰的元素的时候 return
             * 时间复杂度有点高
             */
//            char[] arr = senate.toCharArray();
//            int index = 0;
//            while (true) {
//                int banIndex = getBanIndex(arr, index);
//                if (banIndex == -1) {
//                    return arr[index] == 'R' ? "Radiant" : "Dire";
//                }
//                arr[banIndex] = ' ';
//                int nextIndex = getNextIndex(arr, index);
//                while (arr[nextIndex] == ' ') {
//                    nextIndex = getNextIndex(arr, nextIndex);
//                }
//                index = nextIndex;
//            }
            /**
             * 双数组解法
             * 思路是 一次ban掉一半 所以最多长度为字符串的长度 多一位存储的是最后表决的议员
             * 跟队列思路一样 不过数组内元素修改的时间复杂度要比队列插入的时间复杂度低 所以这里时间复杂度要低一些
             */
            int len = senate.length();
            int[] rNums = new int[len+1], dNums = new int[len+1];
            int rIndex = 0, dIndex = 0;
            for (int i = 0; i < len; i++) {
                if (senate.charAt(i) == 'R') {
                    rNums[rIndex] = i+1;
                    rIndex++;
                } else {
                    dNums[dIndex] = i+1;
                    dIndex++;
                }
            }

            int ptr = 0;
            while (rNums[ptr] != 0 && dNums[ptr] != 0) {
                int r = rNums[ptr], d = dNums[ptr];
                if (r > d) {
                    dNums[dIndex] = d + len;
                    dIndex++;
                } else {
                    rNums[rIndex] = r + len;
                    rIndex++;
                }
                ptr++;
            }
            return rNums[ptr] == 0 ? "Dire" : "Radiant";
        }

        private int getNextIndex(char[] arr, int index) {
            if (index == arr.length - 1) {
                index = 0;
            } else {
                index++;
            }
            return index;
        }

        private int getBanIndex(char[] arr, int index) {
            int lastIndex = 0;
            if (index != arr.length - 1) {
                lastIndex = index + 1;
            }
            char c = arr[index];
            while (lastIndex != index) {
                if (arr[lastIndex] == ' ' || arr[lastIndex] == c) {
                    lastIndex = getNextIndex(arr, lastIndex);
                } else {
                    return lastIndex;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}