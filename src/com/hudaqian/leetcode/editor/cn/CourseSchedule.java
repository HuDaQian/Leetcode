//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1] 
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？ 
//
// 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。 
//
// 示例 2: 
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 1 <= numCourses <= 10^5 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 679 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //  存储有向图
        List<List<Integer>> edges;
        //  标记节点状态：0-未搜索 1-搜索中 2-已搜索
        int[] visited;
        //  使用数组模拟栈，记录结果
        int[] result;
        //  栈索引
        int index;
        //  判断是否有环
        boolean vaild;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            /**
             * 拓扑排序+dfs
             */
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            result = new int[numCourses];
            //  模拟栈 直接从尾部开始写数据
            index = numCourses - 1;
            vaild = true;
            //  构建有向图
            for (int[] prerequisit : prerequisites) {
                edges.get(prerequisit[1]).add(prerequisit[0]);
            }
            int ptr = 0;
            while (vaild && ptr < numCourses) {
                if (visited[ptr] == 0) {
                    dfs(ptr);
                }
                ptr++;
            }
            return vaild;
        }

        private void dfs(int n) {
            //  标记节点为开始搜索
            visited[n] = 1;
            for (int next : edges.get(n)) {
                if (visited[next] == 1) {
                    vaild = false;
                    return;
                }
                if (visited[next] == 0) {
                    dfs(next);
                    if (!vaild) return;
                }
            }
            visited[n] = 2;
            result[index] = n;
            index--;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}