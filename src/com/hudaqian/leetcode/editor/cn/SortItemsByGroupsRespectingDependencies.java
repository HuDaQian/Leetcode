//公司共有 n 个项目和 m 个小组，每个项目要不无人接手，要不就由 m 个小组之一负责。
//
// group[i] 表示第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的）小组可能存
//在没有接手任何项目的情况。
//
// 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：
//
//
// 同一小组的项目，排序后在列表中彼此相邻。
// 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个
//项目左侧）应该完成的所有项目。
//
//
// 如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。
//
//
//
// 示例 1：
//
//
//
//
//输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[
//3,6],[],[],[]]
//输出：[6,3,4,1,5,2,0,7]
//
//
// 示例 2：
//
//
//输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[
//3],[],[4],[]]
//输出：[]
//解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
//
//
//
//
// 提示：
//
//
// 1 <= m <= n <= 3 * 104
// group.length == beforeItems.length == n
// -1 <= group[i] <= m - 1
// 0 <= beforeItems[i].length <= n - 1
// 0 <= beforeItems[i][j] <= n - 1
// i != beforeItems[i][j]
// beforeItems[i] 不含重复元素
//
// Related Topics 深度优先搜索 图 拓扑排序
// 👍 87 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class SortItemsByGroupsRespectingDependencies {
    public static void main(String[] args) {
        Solution solution = new SortItemsByGroupsRespectingDependencies().new Solution();
        int n = 500;
        int m = 440;
        int[] group = {413,165,353,26,346,201,369,340,300,104,105,66,361,15,257,438,375,115,325,290,436,107,394,237,232,79,43,202,185,187,134,298,183,367,326,78,163,79,88,289,377,171,141,107,381,132,177,402,332,232,147,266,208,181,109,260,160,422,21,20,333,262,186,155,436,136,46,299,214,58,194,92,90,286,74,21,196,197,186,261,372,181,312,63,28,108,237,358,337,335,307,153,110,395,238,255,154,263,382,154,125,172,113,367,124,307,129,436,122,396,432,292,57,182,404,278,117,404,221,12,430,176,377,390,388,333,25,16,342,216,127,2,32,154,11,296,412,76,22,345,209,256,256,347,240,362,8,43,122,311,123,379,166,0,285,224,67,246,58,359,37,157,117,221,7,158,140,129,273,299,121,32,190,36,409,229,49,78,141,189,333,105,205,301,403,0,386,431,76,56,200,222,7,120,275,0,225,361,382,209,404,39,26,199,417,215,410,316,108,359,314,260,413,29,337,61,336,422,260,16,141,114,10,348,215,309,12,295,332,191,226,155,337,107,193,148,175,288,58,287,270,84,362,268,218,363,395,345,183,411,82,345,219,390,222,408,205,276,7,9,340,342,413,49,363,6,238,4,416,397,196,74,228,401,200,32,17,153,421,294,401,100,410,273,415,76,141,217,438,239,217,257,321,315,306,299,155,38,43,199,337,97,324,250,268,284,111,377,430,396,298,234,256,358,11,380,56,233,155,28,401,211,134,305,258,125,334,372,317,104,380,197,359,139,224,302,283,401,79,261,68,412,269,259,175,269,231,181,164,278,367,165,241,404,130,64,48,371,203,198,52,115,19,426,358,380,159,304,270,143,99,272,249,228,49,230,10,171,251,213,270,74,377,133,272,349,409,226,421,286,198,65,222,400,76,302,76,207,364,422,266,428,223,305,155,167,302,350,160,237,431,19,22,217,75,281,269,438,290,205,50,342,144,97,142,171,53,114,48,329,422,324,84,275,144,270,275,158,190,421,281,182,210,187,185,419,424,162,123,24,375,19,424,402,95,101,377,298,78,426,20,222,415,47,429,333,429,328,249,314,318,46,217,44,133,348,189,38,19,308,57,70,8,119,33,311,143,134,160,177,187,418,326,66,324,100,172,56,233,33};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(Arrays.asList(381,393,87,478,272,447,2,141,43,222,156,52,41,149,395,374,474,232,106,23,88,101,488,217,100,332,498,227,290,243,291,192,247,37,93,463,216,320,187,376,35,31,490,167,471,275,487,86,453,287,139,89,265,122,49,45,130,399,136,269,133,384,329,163,331,42,160,162,164,484,445,223,357,34,188,154,142,65,24,236,230,315,255,18,126,279,115,61,270,392,412,312,12,363,63,212,91,220,184,388,420,449,482,151,333,155,21,317,282,346,76,479,339,310,152,416,417,289,240,499,391,262,206,57,322,29,176,274,201,172,77,477,60,401,476,480,75,182,432,190,95,177,431,137,234,129,33,297,246,288,361,435,308,112,273,345,335,39,169,375,461,283,92,469,47,411,13,121,438,179,496,303,99,330,210,380,452,455,385,434,404,443,254,466,51,11,485,10,425,135,397,316,410,307,252,344,261,418,202,372,402,146,305,264,20,319,186,351,276,204,242,168,153,200,341,454,311,198,324,98,296,235,424,394,5,405,9,114,66,180,113,73,406,79,194,117,185,448,373,258,53,90,157,62,360,248,250,266,107,386,191,119,105,125,196,80,14,30,225,294,278,78,85,285,249,459,442,382,321,450,253,84,3,181,343,166,481,70,28,301,195,174,457,421,134,390,183,347,292,189,229,193,494,377,419,170,171,138,298,214,144,38,81,218,429,354,423,175,446,215,233,483,161,426,72,422,118,208,8,491,19,468,140,336,413,55,145,383,337,6,306,205,56,309,340,407,314,348,108,159,462,352,433,497));
        beforeItems.add(Arrays.asList(85,486,326,405,88,464));
        beforeItems.add(Arrays.asList(496,272,340,244,414,315,343,382,310,415,77,320,299,302,245,335,151,127,499,495,417,74,122,280,208,242,10,259,447,70,125,487,361,439,477,274,181,413,184,8,476,451,295,84,484,424,119,207,58,86,345,75,405,366,466,371,386,406,106,289,123,55,379,473,216,385,478,270,494,98,107,441,137,493,82,287,195,192,306,165,257,115,365,264,138,470,59,368,230,491,189,62,396,102,265,53,463,285,99,434,356,294,28,363,21,175,456,133,88));
        beforeItems.add(Arrays.asList(80,95,144,318));
        beforeItems.add(Arrays.asList(80,158,369,178,105,443,262,208,60,263,266,147,408,398,422,274,217,142,0,469,332,212,63,489,157,455,396,367,185,153,444,261,2,121,129,415,470,10,288,298,381,287,277,309,248,51,11,246,3,169,485,189));
        beforeItems.add(new ArrayList<>());
        beforeItems.add(new ArrayList<>());
        beforeItems.add(Collections.singletonList(94));
        System.out.print(Arrays.toString(solution.sortItems(n, m, group, beforeItems)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            /**
             * 思路：将项目分成多个组： m + （n中未分配的项目）
             * 先进行同一组别的组内拓扑排序 此时满足第一需求彼此相邻
             * 再进行不同组别之间的拓扑排序 用来满足第二需求
             */
            //  先对项目进行分组 如果项目没有项目组，那么从m开始新建项目组，将其分入

            int ptr = m;
            Map<Integer, List<Integer>> items = new HashMap<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int itemGroup = group[i];
                if (itemGroup == -1) {
                    itemGroup = ptr;
                    ptr++;
                }
                List<Integer> temp = items.getOrDefault(itemGroup, new ArrayList<>());
                temp.add(i);
                items.put(itemGroup, temp);
                map.put(i, itemGroup);
            }

            //  有向图分解到各个组中
            List<List<Integer>> outGroupEdges = new ArrayList<>();
            for (int i = 0; i < ptr; i++) {
                outGroupEdges.add(new ArrayList<>());
            }
            int[] outGroupIndeg = new int[ptr];
            Map<Integer, List<List<Integer>>> edgeMap = new HashMap<>();
            Map<Integer, List<Integer>> indgeMap = new HashMap<>();
            for (int i = 0; i < ptr; i++) {
                List<Integer> nums = items.get(i);
                if (nums == null) continue;
                int len = nums.size();
                List<List<Integer>> temp = new ArrayList<>();
                List<Integer> tempIndge = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    temp.add(new ArrayList<>());
                    tempIndge.add(0);
                }
                edgeMap.put(i, temp);
                indgeMap.put(i, tempIndge);
            }

            for (int i = 0; i < beforeItems.size(); i++) {
                int itemGroup = map.get(i);
                List<Integer> list = beforeItems.get(i);
                for (int j = 0; j < list.size(); j++) {
                    int foreItem = list.get(j);
                    int foreItemGroup = map.get(foreItem);
                    if (itemGroup == foreItemGroup) {
                        List<Integer> item = items.get(itemGroup);

                        int index = item.indexOf(i);
                        int keyIndex = item.indexOf(foreItem);
//                        edgeMap.get(itemGroup).get(keyIndex).add(index);
                        List<List<Integer>> tempEdges = edgeMap.get(itemGroup);
                        List<Integer> tempNextIndex = tempEdges.get(keyIndex);
                        tempNextIndex.add(index);
                        tempEdges.set(keyIndex, tempNextIndex);
                        edgeMap.put(itemGroup, tempEdges);

                        List<Integer> tempIndges = indgeMap.get(itemGroup);
                        int num = tempIndges.get(index);
                        tempIndges.set(index, ++num);
                        indgeMap.put(itemGroup, tempIndges);

                    } else {
                        //  这里直接写入组间有向图
                        outGroupEdges.get(foreItemGroup).add(itemGroup);
                        outGroupIndeg[itemGroup]++;
                    }
                }
            }

            //  组内拓扑
            for (int i = 0; i < ptr; i++) {
                List<Integer> nums = items.get(i);
                if (nums == null) continue;
                List<List<Integer>> edges = edgeMap.get(i);
                int[] groupIndges = indgeMap.get(i).stream().mapToInt(Integer::intValue).toArray();
                List<Integer> sorts = topSort1(nums, edges, groupIndges);
                //  组内拓扑失败
                if (sorts.size() != nums.size()) return new int[0];
                items.put(i, sorts);
            }

            //  组间拓扑代表节点列表
            List<Integer> outGroupItems = new ArrayList<>();
            for (int i = 0; i < ptr; i++) {
                outGroupItems.add(i);
            }

//            List<Integer> groupSorts = topSort(outGroupItems, outGroupEdges);
            List<Integer> groupSorts = topSort1(outGroupItems, outGroupEdges, outGroupIndeg);
            //  组间拓扑失败
            if (groupSorts.size() != outGroupItems.size()) return new int[0];
            int[] result = new int[n];
            int index = 0;
            for (int i : groupSorts) {
                List<Integer> nums = items.get(i);
                if (nums == null) continue;
                for (int j = 0; j < nums.size(); j++) {
                    result[index] = nums.get(j);
                    index++;
                }
            }
            return result;
        }

        private List<Integer> topSort1(List<Integer> items, List<List<Integer>> edges, int[] indeg) {
            if (items.size() == 1 || edges == null) return items;
            List<Integer> result = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indeg.length; i++) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                List<Integer> list = edges.get(curr);
                for (int i = 0; i < list.size(); i++) {
                    int num = list.get(i);
                    if (--indeg[num] == 0) {
                        queue.offer(num);
                    }
                }
                result.add(items.get(curr));
            }
            return result;
        }

        //  拓扑排序 如果有环 则返回空
        private List<Integer> topSort(List<Integer> items, List<List<Integer>> edges) {
            if (items.size() == 1 || edges == null) return items;
            List<Integer> result = new ArrayList<>();
            int len = items.size();
            //  构建入度数组
            int[] indeg = new int[len];
            //  构建有向图
            List<List<Integer>> edge = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                edge.add(new ArrayList<>());
            }
            for (List<Integer> integerList : edges) {
                int num = integerList.get(1);
                int index = items.indexOf(num);

                int key = integerList.get(0);
                int keyIndex = items.indexOf(key);

                edge.get(keyIndex).add(index);
                indeg[index]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < indeg.length; i++) {
                if (indeg[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                List<Integer> list = edge.get(curr);
                for (int i = 0; i < list.size(); i++) {
                    int num = list.get(i);
                    if (--indeg[num] == 0) {
                        queue.offer(num);
                    }
                }
                result.add(items.get(curr));
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}