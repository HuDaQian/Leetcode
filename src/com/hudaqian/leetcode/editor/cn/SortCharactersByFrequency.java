//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 堆 哈希表 
// 👍 180 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class SortCharactersByFrequency {
        public static void main(String[] args) {
            Solution solution = new SortCharactersByFrequency().new Solution();
            System.out.print(solution.frequencySort("tree"));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue() == 0 ? o2.getKey() - o1.getKey() : o2.getValue() - o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<entries.size();i++) {
            Map.Entry<Character, Integer> entry = entries.get(i);
            int index = 0;
            while (index < entry.getValue()) {
                sb.append(entry.getKey());
                index++;
            }
        }
        return sb.toString();
//        for (int i=0;i<s.length();i++) {
//            for (int j=i+1;j<s.length();j++) {
//                if (map.get(schar[i]) < map.get(schar[j])) {
//                    //  调换
//                    char temp = schar[i];
//                    schar[i] = schar[j];
//                    schar[j] = temp;
//                } else if (map.get(schar[i]) == map.get(schar[j])) {
//                    if (schar[i] > schar[j]) {
//                        //  调换
//                        char temp = schar[i];
//                        schar[i] = schar[j];
//                        schar[j] = temp;
//                    }
//                }
//            }
//        }
//        return String.copyValueOf(schar);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }