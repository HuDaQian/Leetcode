//假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 
//个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。 
//
// 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第
// j 个人的属性（queue[0] 是排在队列前面的人）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//解释：
//编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
//编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
//编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
//编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
//编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
//因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
// 
//
// 示例 2： 
//
// 
//输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
//输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= people.length <= 2000 
// 0 <= hi <= 106 
// 0 <= ki < people.length 
// 题目数据确保队列可以被重建 
// 
// Related Topics 贪心算法 
// 👍 742 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        Solution solution = new QueueReconstructionByHeight().new Solution();
        int[][] people = {{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}};
        System.out.print(Arrays.deepToString(solution.reconstructQueue(people)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            //  遍历插入
            //  [4,4] [5,0] [5,2] [6,1] [7,0] [7,1]
            //  [7,0]
            //  [5,0] [7,0]
            //  [5,0] [7,0] [7,1]
            //  [5,0] [7,0] [6,1] [7,1]
            //  [5,0] [7,0] [5,2] [6,1] [7,1]
            //  [5,0] [7,0] [5,2] [6,1] [4,4] [7,1]
            //  解法1：依次按照前面有n个大于它的数字排列
//            if (people == null || people.length == 0) return new int[0][0];
//            List<TwoNumber> list = new ArrayList<>();
//            for (int i = 0; i < people.length; i++) {
//                TwoNumber twoNumber = new TwoNumber(people[i]);
//                list.add(twoNumber);
//            }
//            int count = 0;
//            int ptr = 0;
//            List<List<TwoNumber>> tempList = new ArrayList<>();
//            while (count != list.size()) {
//                List<TwoNumber> temp = new ArrayList<>();
//                for (TwoNumber twoNumber:list) {
//                    if (twoNumber.getSecond() == ptr) {
//                        temp.add(twoNumber);
//                        count++;
//                    }
//                }
//                tempList.add(temp);
//                ptr++;
//            }
//            List<TwoNumber> res = new ArrayList<>();
//            ptr = -1;
//            for (int i = 0; i < tempList.size(); i++) {
//                List<TwoNumber> temp = tempList.get(i);
//                temp.sort(Comparator.comparingInt(TwoNumber::getFirst));
//                for (int j = temp.size()-1; j >=0; j--) {
//                    //  插入
//                    if (ptr == -1) {
//                        res.add(temp.get(j));
//                    } else {
//                        TwoNumber tempNumber = temp.get(j);
//                        int maxCount = tempNumber.getSecond();
//                        while (maxCount != 0 || (ptr<res.size() && res.get(ptr).getFirst()<=tempNumber.getFirst())) {
//                            if (res.get(ptr).getFirst()>=tempNumber.getFirst()) {
//                                maxCount--;
//                            }
//                            ptr++;
//                        }
//                        if (ptr>=res.size()) {
//                            res.add(tempNumber);
//                        } else {
//                            res.add(ptr, tempNumber);
//                        }
//                    }
//                    ptr = 0;
//                }
//            }
//            int[][] result = new int[people.length][2];
//            ptr = 0;
//            for (TwoNumber t:res) {
//                result[ptr++] = t.getNumbers();
//            }
//            return result;
            /**
             * 解法2：从大到小依次排列
             *
             */
//            if (people == null || people.length == 0) return new int[0][0];
//            int len = people.length;
//            List<TwoNumber> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                TwoNumber twoNumber = new TwoNumber(people[i]);
//                list.add(twoNumber);
//            }
//            list.sort((o1, o2) -> o2.getFirst() == o1.getFirst() ? (o1.getSecond() - o2.getSecond()) : o2.getFirst() - o1.getFirst());
//            List<TwoNumber> res = new ArrayList<>();
//            int ptr = -1;
//            for (int i = 0; i < len; i++) {
//                TwoNumber twoNumber = list.get(i);
//                int maxCount = twoNumber.getSecond();
//                ptr += maxCount;
//                if (ptr == -1) {
//                    res.add(twoNumber);
//                } else {
//                    res.add(ptr, twoNumber);
//                }
//                ptr = 0;
//            }
//            int[][] result = new int[people.length][2];
//            ptr = 0;
//            for (TwoNumber t:res) {
//                result[ptr++] = t.getNumbers();
//            }
//            return result;
            /**
             * 解法2优化
             * 上边遍历的时候 发现插入的位置都在maxCount位置
             * 所以 先排序  然后直接插入
             */
            if (people == null || people.length == 0) return people;
            Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
            List<int[]> list = new ArrayList<>();
            for (int[] nums :people) {
                list.add(nums[1], nums);
            }
            return list.toArray(new int[list.size()][2]);
        }

        private class TwoNumber {
            private int[] data;

            public TwoNumber(int[] nums) {
                data = nums;
            }

            public int getFirst() {
                return data[0];
            }

            public int getSecond() {
                return data[1];
            }

            public int[] getNumbers() {
                return data;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}