package com.hudaqian.test;

import java.lang.reflect.Array;
import java.util.*;

public class ExamTest {
    public static void main(String[] args) {
//        Solution solution = new ExamTest().new Solution();
//        String word1 = "g", word2 = "gguggggggguuggguugggggg";
//        System.out.print(solution.largestMerge(word1, word2));

//        int a = 6, b = 2, c = 1;
//        System.out.print(solution.maximumScore(a, b, c));

        TestClass testC = new TestClass();
//        String s = "11100";
//        System.out.print(testC.checkOnesSegment(s));

//        int[] nums = {2,5,5,-7,4};
//        System.out.print(testC.minElements(nums,7,464680098));

//        String s = "leet1234code234";
//        System.out.print(testC.numDifferentIntegers(s));

//        String s = "(name)is(age)yearsold";
//        List knowledge = new ArrayList();
//        knowledge.add(Arrays.asList("name", "bob"));
//        knowledge.add(Arrays.asList("age", "two"));
//        System.out.print(testC.evaluate(s, knowledge));

//        int num = 2;
//        int xPos = 1;
//        int yPos = 0;
//        System.out.print(testC.orchestraLayout(num, xPos, yPos));

//        int[] nums = {1,2,3,3,4,2,5,6,1,2,1,5,4,2};
//        int target = 5;
//        System.out.print(testC.purchasePlans(nums, target));

        int[][] tasks = {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
        System.out.print(Arrays.toString(testC.getOrder(tasks)));

    }

    private static class TestClass {
        private class OperationTask {
            int index;
            int innertime;
            int tasktime;
            public OperationTask(int[] task, int ptr) {
                this.index = ptr;
                this.innertime = task[0];
                this.tasktime = task[1];
            }
        }
        public int[] getOrder(int[][] tasks) {
            List<OperationTask> list = new ArrayList<>();
            for (int i=0; i<tasks.length;i++) {
                list.add(new OperationTask(tasks[i],i));
            }
            list.sort(Comparator.comparingInt(o -> o.innertime));
            Queue<OperationTask> startQueue = new LinkedList<>();
            for (OperationTask task : list) {
                startQueue.offer(task);
            }

            List<OperationTask> queue = new ArrayList<>();
            int[] res = new int[tasks.length];
            int ptr = 0,taskPtr = 0;
            OperationTask currentTask = null;
            int taskStartTime = 0;
            boolean taskLock = false;
            while (true) {
                //  任务增加到队列
                if (startQueue.size() != 0) {
                    OperationTask tmpTask = startQueue.peek();
                    if (tmpTask.innertime == ptr) {
                        while (startQueue.size() != 0 && startQueue.peek().innertime == ptr) {
                            queue.add(startQueue.poll());
                        }
                        Collections.sort(queue, (o1, o2) -> o1.tasktime == o2.tasktime ? o1.index - o2.index : o1.tasktime - o2.tasktime);
                    }
                }
                if (queue.size() != 0) {
                    if (!taskLock) {
                        currentTask = queue.get(0);
                        queue.remove(0);
                        taskStartTime = ptr;
                        res[taskPtr++] = currentTask.index;
                        taskLock = true;
                    } else {
                        //  检查当前时间是否结束
                        if (ptr - taskStartTime == currentTask.tasktime) {
                            currentTask = queue.get(0);
                            queue.remove(0);
                            taskStartTime = ptr;
                            res[taskPtr++] = currentTask.index;
                        }
                    }
                } else {
                    if (currentTask != null && ptr - taskStartTime == currentTask.tasktime) {
                        // 纯解锁
                        taskLock = false;
                    }
                    if (startQueue.size() == 0) break;
                }

                ptr++;
            }
            return res;
        }


        public int getXORSum(int[] arr1, int[] arr2) {
            int res = 0;
            for (int num1 : arr1) {
                for (int num2: arr2) {
                    int tmp = num1 & num2;
                    res = res ^ tmp;
                }
            }
            return res;
        }

        public int orchestraLayout(int num, int xPos, int yPos) {
            if (num == 0) return 0;
            if (num == 1) return 1;
            //  判断点位在哪一层
            //  每一层都是从（xMin,yMin)开始到（xMin,yMax）
            //  再到（xMax,yMax)
            //  再到（xMax，yMin）
            //  再回到（xMin，yMin）
            //  第一个dir xPos==xMin
            //  第二个dir yPos==yMax
            //  第三个dir xPos==xMax
            //  第四个dir yPos==yMin
            int xMin = 0, yMin = 0, xMax = num - 1, yMax = num - 1;
            int floor = 0;
            while (xPos > xMin && xPos < xMax && yPos > yMin && yPos < yMax) {
                floor++;
                xMin++;
                yMin++;
                xMax--;
                yMax--;
            }
            int count = 0;
            int ptr = 0;
            while (floor > 0) {
                count += ((num - 2 * ptr - 1) * 4);
                floor--;
                ptr++;
            }
            if (xPos == xMin) {
                count += yPos - yMin;
            } else if (yPos == yMax) {
                count += num - 2 * ptr - 1;
                count += xPos - xMin;
            } else if (xPos == xMax) {
                count += (num - 2 * ptr - 1) * 2;
                count += yMax - yPos;
            } else {
                count += (num - 2 * ptr - 1) * 3;
                count += xMax - xPos;
            }
            return count % 9 + 1;
        }

        public int purchasePlans(int[] nums, int target) {
            if (nums == null || nums.length < 2) return 0;
            int[] temps = nums.clone();
            Arrays.sort(temps);
            int l = 0, r = 1, count = 0;
            while (temps[r]+temps[l] <= target) {
                count+=(l+1);
                r++;
                l++;
            }
            while (l >= 0 && r < temps.length) {
                if (temps[r]+temps[l] <= target) {
                    count+=(l+1);
                    r++;
                } else {
                    l--;
                }
            }
            return count % (10 ^ 9 + 7);
//            int len = nums.length;
//            int count  = 0;
//            for (int i = 0; i < len; i++) {
//                for (int j = 1; j < len; j++) {
//                    if (nums[i] + nums[j] <= target) count++;
//                }
//            }
//            return count % (10^9 + 7);
        }

        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : answers) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            int count = 0;
            for (int key : map.keySet()) {
                count += (map.get(key) / (key + 1)) * key;
            }
            return count;
        }
//        如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
//        如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
//        6
//        [0, 1, 2, 3, 4, 5]
//        [0, 3, 1, 4, 2, 5]
//        [0, 1, 3, 4, 2, 5]
//        [0, 1, 2, 4, 3, 5]
//        [0, 1, 2, 3, 4, 5]

        public String evaluate(String s, List<List<String>> knowledge) {
            String temp = s;
            Map<String, String> map = new HashMap<>();
            float progress = 1;
            for (List<String> list : knowledge) {
                String keyStr = "(" + list.get(0) + ")";
                String valueStr = list.get(1);
                progress = Math.max(valueStr.length() / keyStr.length(), progress);
                map.put(keyStr, valueStr);
            }
            char[] chars = s.toCharArray();
            char[] resultChars = new char[chars.length * ((int) progress + 1)];

            int prev = -1, resultPtr = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                if (c == '(') {
                    prev = i;
                } else if (c == ')') {
                    String tempKey = s.substring(prev, i + 1);
                    String valueStr = map.getOrDefault(tempKey, "?");
                    char[] values = valueStr.toCharArray();
                    for (char valueC : values) {
                        resultChars[resultPtr++] = valueC;
                    }
                    prev = -1;
                } else {
                    if (prev == -1) {
                        resultChars[resultPtr++] = c;
                    }
                }
            }
            return String.copyValueOf(resultChars).trim();
        }

        public int numDifferentIntegers(String word) {
            char[] chars = word.toCharArray();
            Set<Integer> set = new HashSet<>();
            int tempPtr = -1;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int number = getIsNumber(c);
                if (number == -1) {
                    if (tempPtr != -1) {
                        set.add(tempPtr);
                        tempPtr = -1;
                    }
                } else {
                    if (tempPtr == -1) {
                        tempPtr = number;
                    } else {
                        tempPtr *= 10;
                        tempPtr += number;
                    }
                }
            }
            if (tempPtr != -1) {
                set.add(tempPtr);
            }
            return set.size();
        }

        private int getIsNumber(char c) {
            return c >= '0' && c <= '9' ? Integer.parseInt(String.valueOf(c)) : -1;
        }

        public int findCenter(int[][] edges) {
            int len = edges.length;
            int maxCount = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int[] edge = edges[i];
                int fir = edge[0], sec = edge[1];
                map.put(fir, map.getOrDefault(fir, 0) + 1);
                map.put(sec, map.getOrDefault(sec, 0) + 1);
                if (map.get(fir) != map.get(sec)) {
                    return map.get(fir) > map.get(sec) ? fir : sec;
                }
            }
            return edges[0][0];
        }

        public int minElements(int[] nums, int limit, int goal) {
            /**
             * 防越界
             */
            Arrays.sort(nums);
            int len = nums.length;
            long pres = goal;
            for (int i = 0; i < (len + 1) / 2; i++) {
                if (i != len - i) {
                    pres -= (nums[i] + nums[(len - 1) - i]);
                } else {
                    pres -= nums[i];
                }
            }
            pres = Math.abs(pres);
            int res = (int) (pres / limit);
            int count = (int) (pres % limit);
            return res + (count == 0 ? 0 : 1);
        }

        public boolean checkOnesSegment(String s) {
            char[] chars = s.toCharArray();
            boolean isOne = true;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '0') {
                    isOne = false;
                } else {
                    if (!isOne) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


    public class MaxHeap {
        private List<Integer> data;

        public MaxHeap(int capacity) {
            data = new ArrayList<>(capacity);
        }

        public MaxHeap() {
            data = new ArrayList<>();
        }

        // 返回堆中的元素个数
        public int size() {
            return data.size();
        }

        // 返回一个布尔值, 表示堆中是否为空
        public boolean isEmpty() {
            return data.isEmpty();
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
        private int parent(int index) {
            return (index - 1) / 2;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int leftChild(int index) {
            return index * 2 + 1;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
        private int rightChild(int index) {
            return index * 2 + 2;
        }

        /**
         * @param i
         * @param j
         */
        public void swap(int i, int j) {
            if (i < 0 || i >= size() || j < 0 || j >= size())
                throw new IllegalArgumentException("Index is illegal.");

            Integer temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        /**
         * index 为i位置元素上浮。
         *
         * @param i
         */
        private void siftUp(int i) {
            //特性2：比较插入值和其父结点的大小关系，小于父结点则用父结点替换当前值，index位置上升为父结点
            // 当上浮元素大于父亲，继续上浮。并且不能上浮到0之上
            // 直到i 等于 0 或 比 父亲节点小了。
            while (i > 0 && data.get(i).compareTo(data.get(parent(i))) > 0) {
                // 数组Array中添加方法swap
                swap(i, parent(i));
                i = parent(i); // 这句话让i来到新的位置，使得循环可以查看新的位置是否还要大。
            }
        }

        /**
         * 堆中添加元素方法。
         *
         * @param e
         */
        public void add(Integer e) {
            //特性1：新插入的元素首先放在数组最后，保持完全二叉树的特性
            data.add(e);
            siftUp(data.size() - 1);
        }

        public Integer findMax() {
            return data.get(0);
        }

        public Integer extractMax() {

            Integer ret = findMax();

            swap(0, data.size() - 1); // 0位置元素和最后一个元素互换。
            data.remove(data.size() - 1); // 删除此时的最后一个元素(最小值)
            siftDown(0); // 对于0处进行siftDown操作

            return ret;
        }

        /**
         * k位置元素下移
         *
         * @param k
         */
        private void siftDown(int k) {

            while (leftChild(k) < data.size()) {
                int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
                if (j + 1 < data.size() &&
                        data.get(j + 1).compareTo(data.get(j)) < 0)
                    j++;
                // data[j] 是 leftChild 和 rightChild 中的最小值

                if (data.get(k).compareTo(data.get(j)) >= 0)
                    break;

                swap(k, j);
                k = j;
            }
        }
    }


    private class Solution {
        public int maximumScore(int a, int b, int c) {
            MaxHeap heap = new MaxHeap();
            heap.add(a);
            heap.add(b);
            heap.add(c);
            int score = 0;
            int zero = 0;
            while (zero < 2) {
                int x = heap.extractMax();
                int y = heap.extractMax();
                x--;
                y--;
                score++;
                if (x == 0 && y == 0) {
                    break;
                } else {
                    if (y == 0) {
                        zero++;
                    }
                    heap.add(x);
                    heap.add(y);
                }
            }
            return score;
        }


        /**
         * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
         * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
         * 源数组中可能存在 重复项 。
         * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
         */
        /**
         * 思路 从数组中间分开 然后先判断最后一个元素和第一个元素 然后再判断后边是不是非递减排序
         */
        public boolean check(int[] nums) {
            boolean isMid = false;
            int len = nums.length;
            for (int i = 0; i < len - 1; i++) {
                if (nums[i + 1] < nums[i]) {
                    if (!isMid) {
                        isMid = !isMid;
                        if (nums[len - 1] > nums[0]) {
                            return false;
                        }
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * 给你两个字符串 word1 和 word2 。你需要按下述方式构造一个新字符串 merge ：如果 word1 或 word2 非空，选择 下面选项之一 继续操作：
         * 如果 word1 非空，将 word1 中的第一个字符附加到 merge 的末尾，并将其从 word1 中移除。
         * 例如，word1 = "abc" 且 merge = "dv" ，在执行此选项操作之后，word1 = "bc" ，同时 merge = "dva" 。
         * 如果 word2 非空，将 word2 中的第一个字符附加到 merge 的末尾，并将其从 word2 中移除。
         * 例如，word2 = "abc" 且 merge = "" ，在执行此选项操作之后，word2 = "bc" ，同时 merge = "a" 。
         * 返回你可以构造的字典序 最大 的合并字符串 merge 。
         */
        public String largestMerge(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int l = 0, r = 0;
            char[] temps = new char[m + n];
            char[] aCs = word1.toCharArray(), bCs = word2.toCharArray();
            int ptr = 0;
            while (l < m && r < n) {
                if (aCs[l] > bCs[r]) {
                    temps[ptr++] = aCs[l];
                    l++;
                } else if (aCs[l] < bCs[r]) {
                    temps[ptr++] = bCs[r];
                    r++;
                } else {
                    /**
                     * 依次向后判断 取大的一个
                     */
                    if (isAlargerThanB(aCs, l, bCs, r)) {
                        temps[ptr++] = aCs[l];
                        l++;
                    } else {
                        temps[ptr++] = bCs[r];
                        r++;
                    }
                }
            }
            /**
             * 然后补全数组
             */
            if (l == m) {
                for (int i = r; i < n; i++) {
                    temps[ptr++] = bCs[i];
                }
            } else {
                for (int i = l; i < m; i++) {
                    temps[ptr++] = aCs[i];
                }
            }
            return new String(temps);
        }

        private boolean isAlargerThanB(char[] aCs, int l, char[] bCs, int r) {

            /**
             * 后一位不同的话  取大的那个
             * 后一位相同的话 往后继续找  直找到不同
             * 如果一直比到结束
             */
            /**
             * 一方结束了  调换指针
             */
            int x = l, y = r;
//            l++;
//            r++;
            boolean aReverse = true, bReverse = true;

            while (((aReverse && l < aCs.length) || (!aReverse && l < bCs.length)) && ((bReverse && r < bCs.length) || (!bReverse && r < aCs.length))) {
                char a = aReverse ? aCs[l] : bCs[l];
                char b = bReverse ? bCs[r] : aCs[r];

                if (a > b) {
                    return true;
                } else if (a < b) {
                    return false;
                } else {
                    l++;
                    r++;
                    if (aReverse && l == aCs.length) {
                        l = y;
                        aReverse = false;
                    }
                    if (bReverse && r == bCs.length) {
                        r = x;
                        bReverse = false;
                    }
                }
            }
            return true;
        }
    }
}
