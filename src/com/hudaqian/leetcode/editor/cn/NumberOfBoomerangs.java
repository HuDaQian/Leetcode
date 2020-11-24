//给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺
//序）。 
//
// 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。 
//
// 示例: 
//
// 
//输入:
//[[0,0],[1,0],[2,0]]
//
//输出:
//2
//
//解释:
//两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
// Related Topics 哈希表 数学 
// 👍 117 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new NumberOfBoomerangs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            if (points.length < 3) return 0;
            int res = 0;

            //O(n^2)
            for (int i = 0; i < points.length; i++) {
                Map<Integer, Integer> record = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (j != i)
                        if (record.containsKey(distance(points[i], points[j]))) {
                            record.put(distance(points[i], points[j]),
                                    record.get(distance(points[i], points[j])) + 1);
                        } else
                            record.put(distance(points[i], points[j]), 1);
                }
                for (int k : record.values()) {
                    //这里其实可以不加这句，因为k=1或k=0，结果都是0，但是加上可以减少一定的计算量。
                    if (k >= 2)
                        res += k * (k - 1);
                }

            }

            return res;
        }

        private int distance(int[] x, int[] y) {

            return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}