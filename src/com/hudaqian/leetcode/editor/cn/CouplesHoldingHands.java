//N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交
//换座位。
//
// 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)
//。
//
// 这些情侣的初始座位 row[i] 是由最初始坐在第 i 个座位上的人决定的。
//
// 示例 1:
//
//
//输入: row = [0, 2, 1, 3]
//输出: 1
//解释: 我们只需要交换row[1]和row[2]的位置即可。
//
//
// 示例 2:
//
//
//输入: row = [3, 2, 0, 1]
//输出: 0
//解释: 无需交换座位，所有的情侣都已经可以手牵手了。
//
//
// 说明:
//
//
// len(row) 是偶数且数值在 [4, 60]范围内。
// 可以保证row 是序列 0...len(row)-1 的一个全排列。
//
// Related Topics 贪心算法 并查集 图
// 👍 182 👎 0


package com.hudaqian.leetcode.editor.cn;
public class CouplesHoldingHands {
    public static void main(String[] args) {
        Solution solution = new CouplesHoldingHands().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwapsCouples(int[] row) {
            int ans = 0;
            int[] pos = new int[row.length];

            for (int i = 0; i < pos.length; i++) {
                pos[row[i]] = i;  //每个人对应的位置
            }

            for (int i = 0; i < pos.length; i += 2) {
                int pairPerson = row[i] ^ 0x1;  //i号位置的情侣应该是谁
                if (row[i + 1] == pairPerson) {
                    continue;  //右边是情侣，直接继续处理下一个。
                }

                int nextPerson = row[i + 1]; //右边不是情侣，得到右边的人是谁
                int changePos = pos[pairPerson]; //得到情侣的位置在哪

                row[changePos] = nextPerson; //交换后，情侣位置坐上了右边的人nextPerson
                pos[nextPerson] = changePos; //交换后，右边人nextPerson的位置发生了改变，记录下来。
                ans++;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}