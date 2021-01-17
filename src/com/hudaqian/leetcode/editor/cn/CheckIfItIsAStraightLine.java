//在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为
// x、纵坐标为 y 的点。 
//
// 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
// Related Topics 几何 数组 数学 
// 👍 67 👎 0


package com.hudaqian.leetcode.editor.cn;
public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        Solution solution = new CheckIfItIsAStraightLine().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            /**
             * 后边的点横纵坐标减去前面的点的横纵坐标比例相同即在同一条线上
             */
            if (coordinates == null || coordinates.length < 3) return true;
            int ptr = 0, ptr2 = 0;
            for (int i = 1; i < coordinates.length; i++) {
                int x = coordinates[i][0] - coordinates[ptr2][0];
                int y = coordinates[i][1] - coordinates[ptr2][1];
                if (x != 0 || y!= 0) {
                    if (ptr2 == 0) {
                        ptr2 = i;
                    } else {
                        //  参考线
                        int xPtr = coordinates[ptr2][0] - coordinates[ptr][0];
                        int yPtr = coordinates[ptr2][1] - coordinates[ptr][1];
                        //  比例线
                        int xi = coordinates[i][0] - coordinates[ptr2][0];
                        int yi = coordinates[i][1] - coordinates[ptr2][1];
                        if (xPtr == 0) {
                            //  纵垂直线
                            if (xi != 0) {
                                return false;
                            }
                        } else {
                            if (xi == 0) {
                                if (yi != 0) {
                                    return false;
                                }
                            } else {
                                if (yi/xi != yPtr/xPtr) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}