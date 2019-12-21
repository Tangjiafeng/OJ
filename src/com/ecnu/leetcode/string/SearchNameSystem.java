package com.ecnu.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/search-suggestions-system/
 */
public class SearchNameSystem {
    // Algor of mine: 进行一次字典排序，每次更新（删除不符合前缀要求的字符串）字符串列表。
    // TC: products数量为m，searchWord长度为n；O(m * n)
    // MC:
    // 执行用时 :22 ms, 在所有 java 提交中击败了79.32%的用户
    // 内存消耗 :51.4 MB, 在所有 java 提交中击败了100.00%的用户

    // 优化：增加一个统计数，当统计数等于3时，跳出当前循环。
    // 执行用时 :16 ms, 在所有 java 提交中击败了90.66%的用户
    // 内存消耗 :51.9 MB, 在所有 java 提交中击败了100.00%的用户
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>(searchWord.length());
        List<String> stringList = new ArrayList<>();
        for (String s : products) {
            stringList.add(s);
        }
        Collections.sort(stringList);
        for (int i = 0; i < searchWord.length(); i ++) {
            String prefix = searchWord.substring(0, i + 1);
            int count = 0;
            Iterator<String> index = stringList.iterator();
            while (index.hasNext()) {
                String product = index.next();
                if (count == 3) break;
                if (product.contains(prefix) && product.indexOf(prefix) == 0) {
                    count ++;
                    continue;
                } else {
                    index.remove();// remove 指针前一个元素。
                }
            }
            // copy到另外的list，ans直接add stringList会因为stringList发生改变，
            // 而抛出CurrentModificationException
            ArrayList<String> copyFromStringList = null;

            if (stringList.size() > 3) {
                copyFromStringList = new ArrayList<>(3);
                copyFromStringList.addAll(stringList.subList(0, 3));
            } else {
                copyFromStringList = new ArrayList<>(stringList.size());
                copyFromStringList.addAll(stringList);
            }
            ans.add(copyFromStringList);
        }

        return ans;
    }
}
