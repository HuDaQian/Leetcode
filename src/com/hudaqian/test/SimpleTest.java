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
        int[] nums = {4,2,4,5,6};
        System.out.print(solution.maximumUniqueSubarray(nums));
    }


    public class MinHeap <E extends Comparable<E>> {
        private List<E> data;

        public MinHeap(int capacity){
            data = new ArrayList<>(capacity);
        }

        public MinHeap(){
            data = new ArrayList<>();
        }

        // 返回堆中的元素个数
        public int size(){
            return data.size();
        }

        // 返回一个布尔值, 表示堆中是否为空
        public boolean isEmpty(){
            return data.isEmpty();
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
        private int parent(int index){
            return (index - 1) / 2;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int leftChild(int index){
            return index * 2 + 1;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
        private int rightChild(int index){
            return index * 2 + 2;
        }
    }
    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            /**
             * 维护一个map 和sum
             */
            int sum = 0,res = sum, start = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.getOrDefault(num, 0) != 0) {
                    while (nums[start] != nums[i]) {
                        map.put(nums[start],0);
                        sum-=nums[start];
                        start++;
                    }
                    sum-=nums[start];
                    start++;
                }
                map.put(num, i+1);
                sum+= num;
                res = Math.max(res, sum);

            }
            return res;
        }

        public String reformatNumber(String number) {
            String newNumber = number.replace('-',' ').replace(" ","");
            int len = newNumber.length();
            StringBuilder sb = new StringBuilder();
            int ptr = 0;
            int end = len;
            if (len%3 == 1) {
                end-=4;
            } else if (len%3 == 2) {
                end-=2;
            }
            while(ptr < end) {
                sb.append(newNumber, ptr, ptr+3);
                sb.append("-");
                ptr+=3;
            }
            if (end == len-4) {
                sb.append(newNumber, ptr, ptr+2);
                sb.append("-");
                ptr+=2;
                sb.append(newNumber,ptr, ptr+2);
            } else if (end == len-2){
                sb.append(newNumber, ptr, ptr+2);
            } else {
                sb.deleteCharAt(sb.lastIndexOf("-"));
            }
            return sb.toString();
        }

        public int[] sort(int[] nums) {
            sort(nums,0,nums.length-1);
            return nums;
        }

        private void sort(int[] nums, int startIndex, int endIndex) {
            if (endIndex <= startIndex) {
                return;
            }
            int partiIndex = partitionV2(nums, startIndex, endIndex);
            sort(nums, startIndex, partiIndex-1);
            sort(nums, partiIndex+1, endIndex);
        }

        // 单边扫描
        private int partition(int[] nums, int startIndex, int endIndex) {
            //  随机取一个为基准值
            Random r = new Random();
            int rand = startIndex + r.nextInt(endIndex-startIndex);
            swap(nums, startIndex, rand);
            int res = startIndex;
            int pivot = nums[startIndex];
            for (int i = startIndex+1; i <= endIndex; i++) {
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

            int left = startIndex+1,right = endIndex;
            while(left <= right) {
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
                System.arraycopy(nums2, b, res, index, len1+len2-index);
            } else {
                System.arraycopy(nums1, a, res, index, len1+len2-index);
            }
            return res;
        }
    }
}
