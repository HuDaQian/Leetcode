package com.hudaqian.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {
    public static void main(String[] args) {
        Solution solution = new QuickSortTest().new Solution();
        int[] res = {1,22,4,12,5,6,12,232,5,621,12,11};
//        System.out.print(Arrays.toString(solution.quickSort(res)));
        System.out.print(Arrays.toString(solution.mergeSort(res)));
    }
    private class Solution {
        //  归并排序
        public int[] mergeSort(int[] nums) {
            if (nums == null || nums.length <= 1) return nums;
            int len = nums.length;
            int[] left = new int[len/2];
            int[] right = new int[len - len/2];
            System.arraycopy(nums,0,left,0, len/2);
            System.arraycopy(nums,len/2,right,0, len - len/2);
            if (left.length != 1) {
                left = mergeSort(left);
            }
            if (right.length != 1) {
                right = mergeSort(right);
            }
            return merge(left, right);
        }

        private int[] merge(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0) return nums2;
            if (nums2 == null || nums2.length == 0) return nums1;
            int a = 0, b = 0, ptr = 0;
            int aLen = nums1.length, bLen = nums2.length;
            int[] res = new int[aLen + bLen];
            while (a < aLen && b<bLen) {
                if (nums1[a] < nums2[b]) {
                    res[ptr] = nums1[a];
                    a++;
                } else {
                    res[ptr] = nums2[b];
                    b++;
                }
                ptr++;
            }
            if (a == aLen) {
                System.arraycopy(nums2, b, res, ptr, bLen-b);
            } else {
                System.arraycopy(nums1, a,res, ptr, aLen-a);
            }
//            System.out.print("nums1 -- >" + Arrays.toString(nums1) + "\n");
//            System.out.print("nums2 -- >" + Arrays.toString(nums2) + "\n");
//            System.out.print("res -- >" + Arrays.toString(res) + "\n");
            return res;
        }


        //  普通快排
        public int[] quickSort(int[] nums) {
            quickSort(nums, 0, nums.length-1);
            return nums;
        }
        private void quickSort(int[] nums, int startIndex, int endIndex) {
            if (startIndex >= endIndex) return;
            int partitionIndex = partitionV2(nums, startIndex, endIndex);
            quickSort(nums, startIndex, partitionIndex-1);
            quickSort(nums, partitionIndex+1, endIndex);
        }
        //  单边递归
        private void quickSortV2(int[] nums, int startIndex, int endIndex) {
            while (startIndex < endIndex) {
                int partitionIndex = partitionV2(nums, startIndex, endIndex);
                quickSortV2(nums, partitionIndex, endIndex);
                endIndex = partitionIndex-1;
            }
        }
        //  单边扫描
        private int partition(int[] nums, int startIndex, int endIndex) {
            Random r = new Random();
            int rand = startIndex + r.nextInt(endIndex-startIndex);
            //  把小于rand的放到前面 大于rand的放到后边
            swap(nums, rand, startIndex);
            int pivot = nums[startIndex];
            int ptr = startIndex;
            for (int i = startIndex+1; i <= endIndex; i++) {
                if (nums[i] < pivot) {
                    //  ptr一直指向最后一次调换回来的位置，也就是说ptr后边的数字都比povit大
                    ptr++;
                    swap(nums, ptr, i);
                }
            }
            swap(nums, startIndex, ptr);
            return ptr;
        }
        //  基准值优化
        private int getMidIndex(int[] nums, int startIndex, int endIndex) {
            int midIndex = startIndex + (endIndex - startIndex)/2;
            int fir = -1, sec = -1;
            if (nums[startIndex] > nums[midIndex]) {
                fir = startIndex;
                sec = midIndex;
            } else {
                sec = startIndex;
                fir = midIndex;
            }
            if (nums[endIndex] > nums[fir]) {
                return fir;
            } else {
                if (nums[endIndex] > nums[sec]) {
                    return endIndex;
                } else {
                    return sec;
                }
            }
        }

        //  双边扫描 扫描优化
        private int partitionV2(int[] nums, int startIndex, int endIndex) {
//            int[] temp = new int[endIndex-startIndex+1];
//            System.arraycopy(nums, startIndex, temp, 0, endIndex-startIndex+1);
//            System.out.print(Arrays.toString(temp)+"\n");
//            Random r = new Random();
//            int rand = startIndex + r.nextInt(endIndex-startIndex);
            int rand = getMidIndex(nums, startIndex, endIndex);
            swap(nums, startIndex, rand);
            int pivot = nums[startIndex];
            int left = startIndex+1, right = endIndex;
            while (left <= right) {
                if (nums[left] > pivot && nums[right] < pivot) {
                    swap(nums, left, right);
                    left++;
                    right--;
                    continue;
                }
                if (nums[left] <= pivot) {
                    left++;
                    continue;
                }
                if (nums[right] >= pivot) {
                    right--;
                    continue;
                }
                //  还剩下的情况
                //  1、left和right 都和pivot相等
                //  2、left小于pivot 并且right大于pivot
                left++;
                right--;
            }
            swap(nums, startIndex, right);

//            int[] temp2 = new int[endIndex-startIndex+1];
//            System.arraycopy(nums, startIndex, temp2, 0, endIndex-startIndex+1);
//            System.out.print(Arrays.toString(temp2)+"\n");
            return right;
        }
        private void swap(int[] nums, int startIndex, int endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
        }



    }
}
