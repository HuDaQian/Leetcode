package com.hudaqian.test;

import com.hudaqian.leetcode.editor.cn.ThirdMaximumNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleTest {
    public static void main(String[] args) {
        SimpleTest.Solution solution = new SimpleTest().new Solution();
        int[] nums = {1, 2, 4,3};
        System.out.print(Arrays.toString(solution.sort(nums)));
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

        public int[] sort(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }
            int len = nums.length;
            int[] leftNums = new int[len / 2];
            int[] rightNums = new int[len - len / 2];
            System.arraycopy(nums, 0, leftNums, 0, len / 2);
            System.arraycopy(nums, len / 2, rightNums, 0, len - len / 2);
            if (leftNums.length != 1) {
                leftNums = sort(leftNums);
            }
            if (rightNums.length != 1) {
                rightNums = sort(rightNums);
            }
            return merge(leftNums, rightNums);
        }


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
