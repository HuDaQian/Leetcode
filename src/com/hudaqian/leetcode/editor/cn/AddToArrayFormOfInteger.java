//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 93 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
        int[] A = {4,9};
        int k = 983;
        System.out.print(solution.addToArrayForm(A, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            /**
             * 数组解法
             */
//            int alen = A.length;
//            int klen = String.valueOf(K).length();
//            int len = Math.max(alen, klen);
//            int[] res = new int[len];
//            int ptr = len - 1;
//            int carry = 0;
//            while (ptr >= 0) {
//                int sum;
//                if (alen >0) {
//                    sum = A[alen-1] + K % 10 + carry;
//                    alen--;
//                } else {
//                    sum = K % 10 + carry;
//                }
//                carry = sum / 10;
//                res[ptr] = sum % 10;
//                ptr--;
//                K /= 10;
//            }
//            if (carry != 0) {
//                int[] temp = new int[len+1];
//                temp[0] = 1;
//                for (int i = 0; i < res.length; i++) {
//                    temp[i+1] = res[i];
//                }
//                res = temp;
//            }
//            return Arrays.stream(res).boxed().collect(Collectors.toList());
            /**
             * list解法 最后直接翻转即可
             */
            List<Integer> result = new ArrayList<>();
            int len = A.length;
            int carry = 0;
            while (len > 0) {
                int sum = A[len-1] + K % 10+carry;
                carry = sum / 10;
                result.add(sum%10);
                len--;
                K/=10;
            }
            while (K != 0) {
                int sum = K % 10+carry;
                carry = sum / 10;
                result.add(sum%10);
                K/=10;
            }
            if (carry != 0) {
                result.add(1);
            }
            Collections.reverse(result);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}