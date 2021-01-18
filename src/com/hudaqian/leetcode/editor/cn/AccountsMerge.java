//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。 
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//输出：
//[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
//["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
// 
//
// 
//
// 提示： 
//
// 
// accounts的长度将在[1，1000]的范围内。 
// accounts[i]的长度将在[1，10]的范围内。 
// accounts[i][j]的长度将在[1，30]的范围内。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 153 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        Solution solution = new AccountsMerge().new Solution();
        List<List<String>> accounts = new ArrayList();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        System.out.print(solution.accountsMerge(accounts));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> emailNameMap = new HashMap<>();
            Map<String, Integer> emailIndexMap = new HashMap<>();
            int index = 0;
            for (List<String> list : accounts) {
                String nameStr = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    String emailStr = list.get(i);
                    if (emailIndexMap.getOrDefault(emailStr, -1) != -1) {
                        continue;
                    }
                    emailNameMap.put(emailStr, nameStr);
                    emailIndexMap.put(emailStr, index);
                    index++;
                }
            }
            //  合并
            UnionFind unionFind = new UnionFind(index);
            for (int i = 0; i < accounts.size(); i++) {
                List<String> list = accounts.get(i);
                String firstEmail = list.get(1);
                for (int j = 2; j < list.size(); j++) {
                    String secondEmail = list.get(j);
                    int firstIndex = emailIndexMap.get(firstEmail);
                    int secondIndex =  emailIndexMap.get(secondEmail);
                    unionFind.union(firstIndex, secondIndex);
                }
            }
            //  合成组 邮件的索引 - 邮件的列表
            Map<Integer, List<String>> accountMap = new HashMap<>();
            for (String email : emailIndexMap.keySet()) {
                int emailIndex = emailIndexMap.get(email);
                int key = unionFind.find(emailIndex);
                List<String> valueList = accountMap.getOrDefault(key, new ArrayList<>());
                valueList.add(email);
                accountMap.put(key, valueList);
            }
            //  转化成结果
            List<List<String>> result = new ArrayList<>();
            for (List<String> list: accountMap.values()) {
                Collections.sort(list);
                String email = list.get(0);
                String nameStr = emailNameMap.get(email);
                List<String> tempList = new ArrayList<>();
                tempList.add(nameStr);
                tempList.addAll(list);
                result.add(tempList);
            }
            return result;
        }
        private class UnionFind {
            private int[] parents;
            public UnionFind(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }
            public int find(int n) {
                if (n != parents[n]) {
                    parents[n] = find(parents[n]);
                }
                return parents[n];
            }
            public void union(int x, int y) {
                int xRoot = find(x);
                int yRoot = find(y);
                if (xRoot != yRoot) {
                    parents[yRoot] = xRoot;
                }
            }
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}