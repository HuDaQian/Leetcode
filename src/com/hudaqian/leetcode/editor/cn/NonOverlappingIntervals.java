//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法 
// 👍 274 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        int[][] intervals = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        System.out.print(solution.eraseOverlapIntervals(intervals));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            /**
             * 排序+双指针+贪心
             * 比较a和b 两个数组
             * 如果 a[1] > b[0] 那么这两个数组重叠
             * 我们需要选出末尾比较小的数组保留
             * 如果a[1] > b[1] 那么删除a 否则删除b 相等的时候 因为a[0]<b[0]删除a b都可以
             * 如果a[1] <= b[0] ab不重叠 双指针向后指
             * 注意slow指针要以fast为基准 不是+1
             */
            if (intervals == null || intervals.length <= 1) return 0;
//            这里使用lambda idea会跟踪不到o1 o2报警告
//            Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o1[0] - o2[0]);
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return  o1[0] == o2[0] ? o1[1]-o2[1] : o1[0] - o2[0];
                }
            });
            int len = intervals.length;
            int slow = 0, fast = 1, res = 0;
            while (fast < len) {
                if (intervals[slow][1] > intervals[fast][0]) {
                    res++;
                    slow = intervals[slow][1] > intervals[fast][1] ? fast : slow;
                    fast++;
                } else {
                    slow=fast;
                    fast++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}