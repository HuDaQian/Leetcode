package com.hudaqian.test;

import com.hudaqian.leetcode.editor.cn.ThirdMaximumNumber;

import java.util.*;

public class SimpleTest {
    public static void main(String[] args) {
        SimpleTest.Solution solution = new SimpleTest().new Solution();
//        int[] nums = {3,5,8,1,2,9,4,7,6};
//        System.out.print(Arrays.toString(solution.sort(nums)));
//        String number = "789-0469-2731  5107289";
//        System.out.print(solution.reformatNumber(number));
//        int[] nums = {4, 2, 4, 5, 6};
//        System.out.print(solution.maximumUniqueSubarray(nums));
//        String s = "AbCdEfGh";
//        System.out.print(solution.halvesAreAlike(s));
//        int[] apples = {9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5}, days =
//                {3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};
//        System.out.print(solution.eatenApples(apples, days));
//        int[] jobs = {2, 3, 3, 5, 7, 9, 11};
//        int k = 3;
//        System.out.print(solution.minimumTimeRequired(jobs, k));
        int[][] adjacentPairs =
                {{58689,-49688},{-29753,-26791},{-31884,2158},{-36275,-13544},{54121,-47737},{43373,8173},{86554,67347},{2158,40615},{-8351,73640},{65429,67120},{12321,54121},{95196,-8351},{-65840,11180},{46868,-76136},{-47737,11180},{-76136,-84061},{30983,-54053},{-65840,30983},{-92759,8173},{68192,-49688},{80032,73805},{-35664,82991},{-36275,43373},{-35664,86554},{-29753,41058},{12321,58689},{41058,67120},{73805,-54053},{17313,-92759},{36884,-84224},{-26791,17313},{95196,67347},{-84061,-31884},{-7404,46868},{68192,-13544},{65429,-84224},{36884,73640},{40615,-50164},{66620,82991},{54794,80032},{54794,-7404}};
        System.out.print(Arrays.toString(solution.restoreArray(adjacentPairs)));
    }




    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (k > 1) {
            current = current.next;
            k--;
        }
        ListNode temp = current;
        ListNode ptr = dummy;
        while (current.next.next != null) {
            current = current.next;
            ptr = ptr.next;
        }
        // 交换的是temp.next 和 ptr.next
        if (temp.next == ptr.next) return dummy.next;
        if (temp.next == ptr) {
            temp.next = ptr.next;
            ptr.next.next = temp;
            ptr.next = temp.next.next;
            return dummy.next;
        } else if (ptr.next == temp) {
            ptr.next = temp.next;
            temp.next.next = ptr;
            temp.next = ptr.next.next;
            return dummy.next;
        }

        ListNode lastNode = ptr.next.next;
        ptr.next.next = temp.next.next;
        temp.next.next = lastNode;
        lastNode = ptr.next;
        ptr.next = temp.next;
        temp.next = lastNode;
        return dummy.next;
    }

    int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public class MinHeap {
        private List<Integer> data;

        public MinHeap(int capacity) {
            data = new ArrayList<>(capacity);
        }

        public MinHeap() {
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
            while (i > 0 && data.get(i).compareTo(data.get(parent(i))) < 0) {
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

        public Integer findMin() {
            return data.get(0);
        }

        public Integer extractMin() {

            Integer ret = findMin();

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
                        data.get(j + 1).compareTo(data.get(j)) > 0)
                    j++;
                // data[j] 是 leftChild 和 rightChild 中的最小值

                if (data.get(k).compareTo(data.get(j)) <= 0)
                    break;

                swap(k, j);
                k = j;
            }
        }
    }

    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            if (adjacentPairs == null || adjacentPairs.length == 0) return new int[0];
            int len = adjacentPairs.length+1;
            TUnionFind tUnionFind = new TUnionFind(len);
            int index = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int[] temp = new int[len];
            for (int[] adjancentPair:adjacentPairs) {
                if (map.getOrDefault(adjancentPair[0], -1) == -1) {
                    map.put(adjancentPair[0], index);
                    temp[index++] = adjancentPair[0];
                }
                if (map.getOrDefault(adjancentPair[1], -1) == -1) {
                    map.put(adjancentPair[1], index);
                    temp[index++] = adjancentPair[1];
                }
                tUnionFind.union(map.get(adjancentPair[0]), map.get(adjancentPair[1]));
            }
            int[] indexs = tUnionFind.toArray();
            for (int i = 0; i < len; i++) {
                int t = indexs[i];
                indexs[i] = temp[t];
            }
            return indexs;
        }

        private class TUnionFind {
            /**
             * 魔改并查集
             */
            int[] parents;
            int[] b;

            public TUnionFind(int n) {
                this.parents = new int[n];
                this.b = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                    b[i] = i;
                }
            }

            public int find(int x) {
                while(x != parents[x]) {
                    x = parents[x];
                }
                return x;
            }
            //  根据题意 穿传入的两个数字 一定是两个已经并起来的两个集合的根或者底
            //  eg：1-2-3  4-5-6  一定会传入 1,4或者3,6或者1,6或者3，6
            //  这里要多写一个方法 来调整数组的顺序
            //  1-2-3
            //  2
            private int swap(int bottom) {
                if (bottom == find(bottom)) return bottom;
                int t = swap(parents[bottom]);
                parents[t] = bottom;
                return bottom;
            }
            public void union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot != x && yRoot != y)  {
                    // 都不为根
                    swap(x);
                    parents[x] = x;

                    parents[x] = y;
                    b[yRoot] = xRoot;
                } else if (xRoot == x && yRoot == y) {
                    //  都为根
                    //  查底
                    swap(b[x]);
                    parents[b[x]] = b[x];

                    parents[yRoot] = x;
                    b[find(x)] = b[y];
                } else {
                    if (xRoot == x) {
                        parents[x] = y;
                        b[yRoot] = b[x];
                    } else {
                        parents[y] = x;
                        b[xRoot] = b[y];
                    }
                }
            }
            public int[] toArray() {
                int root = 0;
                for (int i = 0; i < parents.length; i++) {
                    if (parents[i] == i) {
                        root = i;
                        break;
                    }
                }
                int bottom = b[root];
                int[] res = new int[parents.length];
                int ptr = 0;
                while(bottom != parents[bottom]) {
                    res[ptr++] = bottom;
                    bottom = parents[bottom];
                }
                res[ptr++] = bottom;
                return res;
            }
        }

        public int countBalls(int lowLimit, int highLimit) {
            int len = highLimit-lowLimit;
            int ans = Integer.MIN_VALUE;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int num = getSums(lowLimit+i);
                map.put(num,map.getOrDefault(num, 0) + 1);
                ans = Math.max(map.get(num), ans);
            }
            return ans;
        }
        private int getSums(int x) {
            int sum = 0;
            while (x != 0) {
                sum+=x%10;
                x = x/10;
            }
            return sum;
        }

        public int minimumTimeRequired(int[] jobs, int k) {
            Arrays.sort(jobs);
            int len = jobs.length;
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            for (int i = len - 1; i >= 0; i--) {
                if (k > 0) {
                    queue.offer(jobs[i]);
                    k--;
                } else {
                    if (!queue.isEmpty()) {
                        int minNum = queue.poll();
                        queue.offer(minNum + jobs[i]);

                    }
                }
            }
            int res = 0;
            while (!queue.isEmpty()) {
                res = queue.poll();
            }
            return res;
        }

        //        public int[] findBall(int[][] grid) {
//            int m = grid.length;
//            if (m == 0) return new int[0];
//            int n = grid[0].length;
//            int[][] temp = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    int num = grid[i][j];
//                    if (j == 0) {
//                        if (num == -1) {
//                            temp[i][j] = 0;
//                        } else {
//                            temp[i][j] = 1;
//                        }
//                    } else if (j == n-1) {
//                        if (num == 1) {
//                            temp[i][j] = 0;
//                        } else  {
//                            temp[i][j] = -1;
//                        }
//                    } else  {
//                        if (num == 1 && temp[i][j+1] == 1) {
//                            temp[i][j] = 1;
//                        } else if (num == -1 && temp[i][j-1] == -1) {
//                            temp[i][j] = -1;
//                        } else  {
//                            temp[i][j] = 0;
//                        }
//                    }
//                }
//            }
//
//            int[] res = new int[n];
//            for (int i = 0; i < n; i++) {
//                res[i] = i;
//            }
//            for (int i = 1; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    int[] tempNums = new int[n];
//                    if (j == 0) {
//                        int num = temp[i-1][j+1];
//                        if (num == -1) {
//                            tempNums[j] = res[j+1];
//                        } else {
//                            tempNums[j] = -1;
//                        }
//                    } else if (j == n-1) {
//                        int num = temp[i-1][j-1];
//                        if (num == 1) {
//                            tempNums[j] = res[j-1];
//                        } else {
//                            tempNums[j] = -1;
//                        }
//                    } else {
//                        int leftNum = temp[i-1][j-1];
//                        int rightNum = temp[i-1][j+1];
//                    }
//                }
//            }
//        }
        public int eatenApples(int[] apples, int[] days) {
            /**
             * 贪心解法 + 模拟
             */
            int len = apples.length;
            if (len == 0) return 0;
            int maxLen = 0;
            for (int i = 0; i < len; i++) {
                int day = days[i];
                maxLen = Math.max(maxLen, i + day);
            }
            int[] temp = new int[maxLen];
            int ptr = 0;
            int count = 0;
            for (int i = 0; i < len; i++) {
                int apple = apples[i];
                int day = days[i];
                if (i + day <= ptr) continue;
                ptr = Math.max(ptr, i);
                while (ptr < i + day && apple > 0) {
                    if (temp[ptr] == 0) {
                        temp[ptr]++;
                        count++;
                        apple--;
                    }
                    ptr++;
                }
            }
            return count;
        }

        public boolean halvesAreAlike(String s) {
            int temp = 0;
            char[] sArr = s.toCharArray();
            int len = sArr.length;
            for (int i = 0; i < len; i++) {
                char c = sArr[i];
                if (i >= len / 2) {
                    temp -= isCount(c);
                } else {
                    temp += isCount(c);
                }
            }
            return temp == 0;
        }

        private int isCount(char c) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    return 1;
                default:
                    return 0;
            }
        }

        public int getMaxNumber(int[] nums) {
            /**
             * 贪心
             */
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            char[] res = new char[sum * 3];
            int fir = 0;
            while (fir < nums[0]) {
                res[fir * 3] = 'a';
            }
            int sec = 0;
            while (sec < nums[1]) {
                res[sec * 3 + 1] = 'b';
            }
            int last = sum - fir - sec;
            int index = 0;
            int ptr = 2;
            for (int i = 0; i < last; i++) {
                int temp = 0;
                if (res[index * 3 + 2] == ' ') {
                    temp = index * 3 + 2;
                    if (res[index * 3 + 1] == ' ') {
                        temp = index + 1;
                        if (res[index * 3] == ' ') {
                            temp = index * 3;
                        }
                    }
                }
                if (nums[ptr]-- <= 0) {
                    ptr++;
                }
                res[temp] = (char) ('c' + ptr - 2);
            }
            /**
             * 交换
             */
            while (index >= 0 && res[index * 3] != ' ' && res[index * 3 + 1] != ' ' && res[index * 3 + 2] != ' ') {
                index--;
            }
            return index;
        }

        public int maximumUniqueSubarray(int[] nums) {
            /**
             * 维护一个map 和sum
             */
            int sum = 0, res = sum, start = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.getOrDefault(num, 0) != 0) {
                    while (nums[start] != nums[i]) {
                        map.put(nums[start], 0);
                        sum -= nums[start];
                        start++;
                    }
                    sum -= nums[start];
                    start++;
                }
                map.put(num, i + 1);
                sum += num;
                res = Math.max(res, sum);

            }
            return res;
        }

        public String reformatNumber(String number) {
            String newNumber = number.replace('-', ' ').replace(" ", "");
            int len = newNumber.length();
            StringBuilder sb = new StringBuilder();
            int ptr = 0;
            int end = len;
            if (len % 3 == 1) {
                end -= 4;
            } else if (len % 3 == 2) {
                end -= 2;
            }
            while (ptr < end) {
                sb.append(newNumber, ptr, ptr + 3);
                sb.append("-");
                ptr += 3;
            }
            if (end == len - 4) {
                sb.append(newNumber, ptr, ptr + 2);
                sb.append("-");
                ptr += 2;
                sb.append(newNumber, ptr, ptr + 2);
            } else if (end == len - 2) {
                sb.append(newNumber, ptr, ptr + 2);
            } else {
                sb.deleteCharAt(sb.lastIndexOf("-"));
            }
            return sb.toString();
        }

        public int[] sort(int[] nums) {
            sort(nums, 0, nums.length - 1);
            return nums;
        }

        private void sort(int[] nums, int startIndex, int endIndex) {
            if (endIndex <= startIndex) {
                return;
            }
            int partiIndex = partitionV2(nums, startIndex, endIndex);
            sort(nums, startIndex, partiIndex - 1);
            sort(nums, partiIndex + 1, endIndex);
        }

        // 单边扫描
        private int partition(int[] nums, int startIndex, int endIndex) {
            //  随机取一个为基准值
            Random r = new Random();
            int rand = startIndex + r.nextInt(endIndex - startIndex);
            swap(nums, startIndex, rand);
            int res = startIndex;
            int pivot = nums[startIndex];
            for (int i = startIndex + 1; i <= endIndex; i++) {
                if (nums[i] < pivot) {
                    res++;
                    swap(nums, res, i);
                }
            }
            //  在循环过程中，指针一直指向最后一个比基准值小的元素
            //  调换基准和当前指针的数值
            swap(nums, startIndex, res);
            return res;
        }

        //  双边扫描
        private int partitionV2(int[] nums, int startIndex, int endIndex) {
            //  随机取一个为基准值
//            Random r = new Random();
//            int rand = startIndex + r.nextInt(endIndex-startIndex);
//            swap(nums, startIndex, rand);
            int pivot = nums[startIndex];

            int left = startIndex + 1, right = endIndex;
            while (left <= right) {
                if (nums[left] > pivot && nums[right] < pivot) {
                    swap(nums, left, right);
                    left++;
                    right--;
                    continue;
                }
                if (nums[left] < pivot) {
                    left++;
                    continue;
                }
                if (nums[right] > pivot) {
                    right--;
                    continue;
                }
                left++;
                right--;
            }
            swap(nums, startIndex, right);
            return right;
        }

        private void swap(int[] nums, int startIndex, int endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
        }


//        public int[] sort(int[] nums) {
//            if (nums.length <= 1) {
//                return nums;
//            }
//            int len = nums.length;
//            int[] leftNums = new int[len / 2];
//            int[] rightNums = new int[len - len / 2];
//            System.arraycopy(nums, 0, leftNums, 0, len / 2);
//            System.arraycopy(nums, len / 2, rightNums, 0, len - len / 2);
//            if (leftNums.length != 1) {
//                leftNums = sort(leftNums);
//            }
//            if (rightNums.length != 1) {
//                rightNums = sort(rightNums);
//            }
//            return merge(leftNums, rightNums);
//        }


        private int[] merge(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return nums2;
            if (nums2 == null || nums2.length == 0) return nums1;
            int a = 0, b = 0;
            int len1 = nums1.length, len2 = nums2.length;
            int[] res = new int[len1 + len2];
            int index = 0;
            while (a < len1 && b < len2) {
                int aNum = nums1[a];
                int bNum = nums2[b];
                if (aNum < bNum) {
                    res[index] = aNum;
                    a++;
                } else {
                    res[index] = bNum;
                    b++;
                }
                index++;
            }
            if (a == len1) {
                System.arraycopy(nums2, b, res, index, len1 + len2 - index);
            } else {
                System.arraycopy(nums1, a, res, index, len1 + len2 - index);
            }
            return res;
        }
    }
}
