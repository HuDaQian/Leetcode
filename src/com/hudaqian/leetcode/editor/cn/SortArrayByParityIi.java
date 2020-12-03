//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 183 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class SortArrayByParityIi {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParityIi().new Solution();
        int[] nums = {1, 3, 4, 2};
        System.out.print(Arrays.toString(solution.sortArrayByParityII(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParityII(int[] A) {
            /**
             * 解法1：新增数组 奇偶指针插入数据
             */
//            if (A.length < 2) return A;
//            int left = 0, right = 1;
//            int[] res = new int[A.length];
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] % 2 == 0) {
//                    res[left] = A[i];
//                    left += 2;
//                } else {
//                    res[right] = A[i];
//                    right += 2;
//                }
//            }
//            return res;
            /**
             * 解法2：奇偶栈
             * 异常位存储到栈中等待交换
             */
//            Stack<Integer> odd = new Stack<Integer>();
//            Stack<Integer> even = new Stack<Integer>();
//            for (int i = 0; i < A.length; i++) {
//                if ((A[i] % 2) - (i % 2) != 0) {
//                    if (i % 2 == 0) {
//                        //  偶数位 出现奇数 如果偶数栈中有数 那么交换当前位置的数和栈中记录的位置对应的数 如果偶数栈中没有数字 那么将数字存入奇数栈
//                        if (even.empty()) {
//                            odd.push(i);
//                        } else {
//                            swap(A, even.pop(), i);
//                        }
//                    } else {
//                        if (odd.empty()) {
//                            even.push(i);
//                        } else {
//                            swap(A, odd.pop(), i);
//                        }
//                    }
//                }
//            }
//            return A;
            /**
             * 解法3：双指针
             */
            if(A.length < 2) return A;
            int odd=1;
            for (int even = 0; even < A.length; even+=2) {
                //  前进even指针 直到其为奇数
                if (A[even]%2 != 0) {
                    //  前进odd指针 直到其为偶数
                    while (A[odd]%2 != 0) {
                        odd+=2;
                    }
                    //  交换odd指针和even指针对应的值
                    A[odd] = A[odd] ^ A[even];
                    A[even] = A[even] ^ A[odd];
                    A[odd] = A[odd] ^ A[even];
                }
            }
            return A;
        }

        private void swap(int[] num, int index, int changeIndex) {
            int temp = num[index];
            num[index] = num[changeIndex];
            num[changeIndex] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}