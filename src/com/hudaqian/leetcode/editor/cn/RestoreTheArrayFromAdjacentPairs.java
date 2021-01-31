//存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
//
// 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui
// 和 vi 在 nums 中相邻。
//
// 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i]
//, nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
//
// 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
//
//
//
// 示例 1：
//
//
//输入：adjacentPairs = [[2,1],[3,4],[3,2]]
//输出：[1,2,3,4]
//解释：数组的所有相邻元素对都在 adjacentPairs 中。
//特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
//
//
// 示例 2：
//
//
//输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
//输出：[-2,4,1,-3]
//解释：数组中可能存在负数。
//另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
//
//
// 示例 3：
//
//
//输入：adjacentPairs = [[100000,-100000]]
//输出：[100000,-100000]
//
//
//
//
// 提示：
//
//
// nums.length == n
// adjacentPairs.length == n - 1
// adjacentPairs[i].length == 2
// 2 <= n <= 105
// -105 <= nums[i], ui, vi <= 105
// 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
//
// Related Topics 贪心算法
// 👍 0 👎 0


package com.hudaqian.leetcode.editor.cn;

import com.hudaqian.test.SimpleTest;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        Solution solution = new RestoreTheArrayFromAdjacentPairs().new Solution();
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        System.out.print(Arrays.toString(solution.restoreArray(adjacentPairs)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            if (adjacentPairs == null || adjacentPairs.length == 0) return new int[0];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < adjacentPairs.length; i++) {
                int fir = adjacentPairs[i][0];
                int sec = adjacentPairs[i][1];
                List<Integer> list1 = map.getOrDefault(fir, new ArrayList<>());
                list1.add(sec);
                map.put(fir, list1);
                List<Integer> list2 = map.getOrDefault(sec, new ArrayList<>());
                list2.add(fir);
                map.put(sec, list2);
            }
            int first = Integer.MIN_VALUE;
            for (int num : map.keySet()) {
                if (map.getOrDefault(num, new ArrayList<>()).size() == 1) {
                    first = num;
                    break;
                }
            }
            int len = adjacentPairs.length+1;
            int[] result = new int[len];
//            int[] visited = new int[len];
            Set<Integer> set = new HashSet<>();
            int ptr = 0;
            set.add(first);
            while (ptr < len) {
                result[ptr] = first;
                List<Integer> temp = map.getOrDefault(first, new ArrayList<>());
                for (int num:temp) {
                    if (set.add(num)) {
                        first = num;
                        break;
                    }
                }
                ptr++;
            }
            return result;
        }
        /**
         * 双链表解法
         * 超时
         */
//        public int[] restoreArray(int[][] adjacentPairs) {
//            if (adjacentPairs == null || adjacentPairs.length == 0) return new int[0];
//            int len = adjacentPairs.length;
//            int[] visited = new int[len];
//            MyLinkedList myLinkedList = new MyLinkedList();
//
//            visited[0] = 1;
//            int fir = adjacentPairs[0][0], sec = adjacentPairs[0][1];
//            myLinkedList.addAtHead(fir);
//            myLinkedList.addAtTail(sec);
//            for (int i=0;i<len;i++) {
//                if (visited[i] == 1) continue;
//                int[] nums = adjacentPairs[i];
//                if (nums[0] == sec || nums[1] == sec) {
//                    //  尾部增加
//                    sec = (nums[0] == sec) ? nums[1] : nums[0];
//                    myLinkedList.addAtTail(sec);
//                    visited[i] = 1;
//                    i = 0;
//                } else if (nums[0] == fir || nums[1] == fir) {
//                    //  头部增加
//                    fir = (nums[0] == fir) ? nums[1] : nums[0];
//                    myLinkedList.addAtHead(fir);
//                    visited[i] = 1;
//                    i = 0;
//                }
//            }
//            return myLinkedList.toArrays();
//        }
//        /**
//         * 双链表解法
//         *
//         */
//
//        private class DoubleNode {
//            int val;
//            DoubleNode next;
//            DoubleNode prev;
//
//            DoubleNode(int val) {
//                this.val = val;
//            }
//        }
//
//        private class MyLinkedList {
//            int size;
//            DoubleNode head, tail;
//
//            public MyLinkedList() {
//                size = 0;
//                head = new DoubleNode(0);
//                tail = new DoubleNode(0);
//                head.next = tail;
//                tail.prev = head;
//            }
//
//            public int get(int index) {
//                if (index < 0 || index >= size) return -1;
//                DoubleNode current = head;
//                //  调整一下  如果index>size/2 那么从后边开始搜索
//                if (index > size / 2) {
//                    current = tail;
//                    //  结尾开始
//                    while (index < size) {
//                        current = current.prev;
//                        index++;
//                    }
//                } else {
//                    while (index >= 0) {
//                        current = current.next;
//                        index--;
//                    }
//                }
//
//                return current.val;
//            }
//
//            public void addAtIndex(int index, int val) {
//                if (index > size) return;
//                if (index < 0) index = 0;
//                DoubleNode temp = head;
//                if (index > size / 2) {
//                    //  从后往前搜索 这次是搜索前一个结点 在其之后插入 所以多走一步
//                    temp = tail;
//                    while (index <= size) {
//                        temp = temp.prev;
//                        index++;
//                    }
//                } else {
//                    while (index > 0) {
//                        temp = temp.next;
//                        index--;
//                    }
//                }
//                size++;
//                DoubleNode newNode = new DoubleNode(val);
//                DoubleNode backNode = temp.next;
//                temp.next = newNode;
//                newNode.prev = temp;
//                newNode.next = backNode;
//                backNode.prev = newNode;
//            }
//
//            public void addAtHead(int val) {
//                addAtIndex(0, val);
//            }
//
//            public void addAtTail(int val) {
//                addAtIndex(size, val);
//            }
//
//            public void deleteAtIndex(int index) {
//                if (index < 0 || index > size - 1) return;
//                DoubleNode temp = head;
//                if (index > size / 2) {
//                    //  从后往前搜索
//                    temp = tail;
//                    while (index < size) {
//                        temp = temp.prev;
//                        index++;
//                    }
//                } else {
//                    while (index >= 0) {
//                        temp = temp.next;
//                        index--;
//                    }
//                }
//                size--;
//                DoubleNode foreNode = temp.prev;
//                DoubleNode backNode = temp.next;
//                foreNode.next = backNode;
//                backNode.prev = foreNode;
//            }
//            public int[] toArrays () {
//                int[] res = new int[size];
//                int ptr = 0;
//                DoubleNode dummy = head.next;
//                while (dummy.next != null) {
//                    res[ptr++] = dummy.val;
//                    dummy = dummy.next;
//                }
//                return res;
//            }
//        }


        // list解法
        //  超时
//        public int[] restoreArray(int[][] adjacentPairs) {
//            if (adjacentPairs == null || adjacentPairs.length == 0) return new int[0];
//            int len = adjacentPairs.length;
//            List<Integer> list = new ArrayList<>();
//            int[] visited = new int[len];
//
//            visited[0] = 1;
//            int fir = adjacentPairs[0][0], sec = adjacentPairs[0][1];
//            list.add(fir);
//            list.add(sec);
//            for (int i = 1; i < len; i++) {
//                if (visited[i] == 1) continue;
//                int[] nums = adjacentPairs[i];
//                if (nums[0] == sec || nums[1] == sec) {
//                    //  尾部增加
//                    sec = (nums[0] == sec) ? nums[1] : nums[0];
//                    list.add(sec);
//                    visited[i] = 1;
//                    i = 0;
//                } else if (nums[0] == fir || nums[1] == fir) {
//                    //  头部增加
//                    Collections.reverse(list);
//                    int temp = fir;
//                    fir = sec;
//                    sec = temp;
//                    sec = (nums[0] == sec) ? nums[1] : nums[0];
//                    list.add(sec);
//                    visited[i] = 1;
//                    i = 0;
//                }
//            }
//            return list.stream().mapToInt(Integer::intValue).toArray();
//        }

        /**
         * 魔改并查集解法
         * 超时
         */
//           public int[] restoreArray(int[][] adjacentPairs) {
//               if (adjacentPairs == null || adjacentPairs.length == 0) return new int[0];
//               int len = adjacentPairs.length+1;
//               SimpleTest.Solution.TUnionFind tUnionFind = new SimpleTest.Solution.TUnionFind(len);
//               int index = 0;
//               Map<Integer, Integer> map = new HashMap<>();
//               int[] temp = new int[len];
//               for (int[] adjancentPair:adjacentPairs) {
//                   if (map.getOrDefault(adjancentPair[0], -1) == -1) {
//                       map.put(adjancentPair[0], index);
//                       temp[index++] = adjancentPair[0];
//                   }
//                   if (map.getOrDefault(adjancentPair[1], -1) == -1) {
//                       map.put(adjancentPair[1], index);
//                       temp[index++] = adjancentPair[1];
//                   }
//                   tUnionFind.union(map.get(adjancentPair[0]), map.get(adjancentPair[1]));
//               }
//               int[] indexs = tUnionFind.toArray();
//               for (int i = 0; i < len; i++) {
//                   int t = indexs[i];
//                   indexs[i] = temp[t];
//               }
//               return indexs;
//           }
//
//           private class TUnionFind {
//               /**
//                * 魔改并查集
//                */
//               int[] parents;
//               int[] b;
//
//               public TUnionFind(int n) {
//                   this.parents = new int[n];
//                   this.b = new int[n];
//                   for (int i = 0; i < n; i++) {
//                       parents[i] = i;
//                       b[i] = i;
//                   }
//               }
//
//               public int find(int x) {
//                   while(x != parents[x]) {
//                       x = parents[x];
//                   }
//                   return x;
//               }
//               //  根据题意 穿传入的两个数字 一定是两个已经并起来的两个集合的根或者底
//               //  eg：1-2-3  4-5-6  一定会传入 1,4或者3,6或者1,6或者3，6
//               //  这里要多写一个方法 来调整数组的顺序
//               //  1-2-3
//               //  2
//               private int swap(int bottom) {
//                   if (bottom == find(bottom)) return bottom;
//                   int t = swap(parents[bottom]);
//                   parents[t] = bottom;
//                   return bottom;
//               }
//               public void union(int x, int y) {
//                   int xRoot = find(x);
//                   int yRoot = find(y);
//                   if (xRoot != x && yRoot != y)  {
//                       // 都不为根
//                       swap(x);
//                       parents[x] = x;
//
//                       parents[x] = y;
//                       b[yRoot] = xRoot;
//                   } else if (xRoot == x && yRoot == y) {
//                       //  都为根
//                       //  查底
//                       swap(b[x]);
//                       parents[b[x]] = b[x];
//
//                       parents[yRoot] = x;
//                       b[find(x)] = b[y];
//                   } else {
//                       if (xRoot == x) {
//                           parents[x] = y;
//                           b[yRoot] = b[x];
//                       } else {
//                           parents[y] = x;
//                           b[xRoot] = b[y];
//                       }
//                   }
//               }
//               public int[] toArray() {
//                   int root = 0;
//                   for (int i = 0; i < parents.length; i++) {
//                       if (parents[i] == i) {
//                           root = i;
//                           break;
//                       }
//                   }
//                   int bottom = b[root];
//                   int[] res = new int[parents.length];
//                   int ptr = 0;
//                   while(bottom != parents[bottom]) {
//                       res[ptr++] = bottom;
//                       bottom = parents[bottom];
//                   }
//                   res[ptr++] = bottom;
//                   return res;
//               }
//           }

    }
//leetcode submit region end(Prohibit modification and deletion)

}