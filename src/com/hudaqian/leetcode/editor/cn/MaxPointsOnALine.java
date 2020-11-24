//给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[3,3]]
//输出: 3
//解释:
//^
//|
//|        o
//|     o
//|  o  
//+------------->
//0  1  2  3  4
// 
//
// 示例 2: 
//
// 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出: 4
//解释:
//^
//|
//|  o
//|     o        o
//|        o
//|  o        o
//+------------------->
//0  1  2  3  4  5  6 
// Related Topics 哈希表 数学 
// 👍 199 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            if (points.length < 3) return points.length;
            int maxC = 0;
            // 每个点
            for (int i = 0; i < points.length; i++) {
                int duplicate = 1;
                Map<String, Integer> cmap = new HashMap<String, Integer>();
                for (int j = i + 1; j < points.length; j++) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        duplicate++;
                    } else {
                        String s = GetLineInfo(points[i], points[j]);
                        if (!cmap.containsKey(s)) cmap.put(s, 1);
                        else cmap.replace(s, cmap.get(s), cmap.get(s) + 1);
                    }
                }
                if (cmap.isEmpty()) maxC = Math.max(maxC, duplicate);
                else
                    for (int x : cmap.values()) {
                        maxC = Math.max(maxC, x + duplicate);
                    }
            }
            return maxC;
        }

        private String GetLineInfo(int[] pointA, int[] pointB) {
            if (pointA[1] == pointB[1] && pointA[0] == pointB[0]) return "samePoint";
            if (pointA[1] == pointB[1]) return "0";
            if (pointA[0] == pointB[0]) return "Inf";

            int xA = pointA[0];
            int yA = pointA[1];
            int xB = pointB[0];
            int yB = pointB[1];
            int xS = xB - xA;
            int yS = yB - yA;
            boolean isPositive = xS * yS >= 0;
            int maxDivistor = GetCountDivistor(Math.abs(xS), Math.abs(yS));
            xS = isPositive ? Math.abs(xS) / maxDivistor : -Math.abs(xS) / maxDivistor;
            yS = Math.abs(yS) / maxDivistor;
            return xS + "/" + yS;
        }

        private int GetCountDivistor(int a, int b) {
            if (a < b) {
                return GetCountDivistor(b, a);
            }
            int r = a % b;
            while (r != 0) {
                a = b;
                b = r;
                r = a % b;
            }
            return b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}