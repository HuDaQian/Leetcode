//在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你
//会得到一张含有有效单词的列表。映射如下图所示： 
//
// 
//
// 示例 1: 
//
// 输入: num = "8733", words = ["tree", "used"]
//输出: ["tree", "used"]
// 
//
// 示例 2: 
//
// 输入: num = "2", words = ["a", "b", "c", "d"]
//输出: ["a", "b", "c"] 
//
// 提示： 
//
// 
// num.length <= 1000 
// words.length <= 500 
// words[i].length == num.length 
// num中不会出现 0, 1 这两个数字 
// 
// Related Topics 数组 
// 👍 18 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T9Lcci {
    public static void main(String[] args) {
        Solution solution = new T9Lcci().new Solution();
        String num = "9675973753";
        String[] words = {"tree","used"};
        System.out.print(solution.getValidT9Words(num, words).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> getValidT9Words(String num, String[] words) {
            /**
             * 暴力解法
             */
//            List<String> list = new ArrayList<>(Arrays.asList(words));
//            char[] chars = num.toCharArray();
//            for (int j = 0; j < words.length; j++) {
//                String str = list.get(j);
//                if (str.length() != num.length()) {
//                    list.remove(str);
//                }
//            }
//            for (int i = 0; i < chars.length; i++) {
//                int tempNum = chars[i] - '0';
//                for (int j = 0; j < list.size(); j++) {
//                    String str = list.get(j);
//                    char[] strs = str.toCharArray();
//                    int charNum = getCharacterNumber(strs[i]);
//                    if (charNum != tempNum) {
//                        list.remove(str);
//                    }
//                }
//            }
//            return list;
            /**
             * 数组
             */
            int[] nums = new int[26];
            nums[25] = 9;
            for (int i = 0; i < 25; i++) {
                int tempNum = i >= 18 ? i-1 : i;
                nums[i] = tempNum/3+2;
            }
            List<String> list = new ArrayList<>(Arrays.asList(words));
            list.removeIf(word -> word.length() != num.length() || !checkStatus(nums, word, num));
            return list;
        }
        private boolean checkStatus(int[] nums, String word, String num) {
            char[] chars = word.toCharArray();
            char[] numsC = num.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (nums[chars[i]-'a'] != (numsC[i] - '0')) return false;
            }
            return true;
        }

        private int getCharacterNumber(Character c) {
            if (c == 'z') {
                return 9;
            }
            if (c >= 's') c--;
            return (c - 'a') / 3 + 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}