//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 
//
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 329 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
        int number = 2;
        int[][] prerequisites = {{1,0}};
        System.out.print(solution.findOrder(number, prerequisites));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //  dfs参数
//        //  存储有向图
//        List<List<Integer>> edges;
//        //  标记节点状态：0-未搜索 1-搜索中 2-已搜索
//        int[] visited;
//        //  使用数组模拟栈，记录结果
//        int[] result;
//        //  栈索引
//        int index;
//        //  判断是否有环
//        boolean vaild;
//
        // bfs参数
        //  存储有向图
        List<List<Integer>> edges;
        //  存储入度
        int[] indeg;
        //  缓存队列
        Queue<Integer> queue;
        //  存储结果
        int[] result;
        //  结果索引
        int index;


        public int[] findOrder(int numCourses, int[][] prerequisites) {
            /**
             * 拓扑排序+dfs
             */
//            edges = new ArrayList<List<Integer>>();
//            for (int i = 0; i < numCourses; i++) {
//                edges.add(new ArrayList<>());
//            }
//            visited = new int[numCourses];
//            result = new int[numCourses];
//            //  模拟栈 直接从尾部开始写数据
//            index = numCourses-1;
//            vaild = true;
//            //  构建有向图
//            for (int[] prerequisit:prerequisites) {
//                edges.get(prerequisit[1]).add(prerequisit[0]);
//            }
//            int ptr = 0;
//            while (vaild && ptr<numCourses) {
//                if (visited[ptr] == 0) {
//                    dfs(ptr);
//                }
//                ptr++;
//            }
//            return vaild ?  result : new int[0];
            /**
             * 拓扑排序+bfs
             */
            edges = new ArrayList<List<Integer>>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            indeg = new int[numCourses];
            result = new int[numCourses];
            index = 0;
            queue = new LinkedList<>();
            //  构建有向图 和存储入度
            for (int[] prerequisit : prerequisites) {
                edges.get(prerequisit[1]).add(prerequisit[0]);
                indeg[prerequisit[0]]++;
            }
            return bfs() ? result : new int[0];
        }
        private boolean bfs() {
            //  入度为0的节点放入队列中
            for (int i = 0; i < indeg.length; i++) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
            //  按顺序将队列中的节点出栈
            //  节点出栈的时候 其下级节点入度减1
            //  然后将入度为0的节点加入队列
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                List<Integer> list = edges.get(curr);
                for (int i = 0; i < list.size(); i++) {
                    int num = list.get(i);
                    if(--indeg[num] == 0) {
                        queue.offer(num);
                    }
                }
                result[index] = curr;
                index++;
            }
            return index == result.length;
        }
    }

//        private void dfs(int n) {
//            //  标记节点为开始搜索
//            visited[n] = 1;
//            for (int next : edges.get(n)) {
//                if (visited[next] == 1) {
//                    vaild = false;
//                    return;
//                }
//                if (visited[next] == 0) {
//                    dfs(next);
//                    if (!vaild) return;
//                }
//            }
//            visited[n] = 2;
//            result[index] = n;
//            index--;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}