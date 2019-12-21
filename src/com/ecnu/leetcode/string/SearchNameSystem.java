package com.ecnu.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/search-suggestions-system/
 */
public class SearchNameSystem {
    // Algor of mine: ����һ���ֵ�����ÿ�θ��£�ɾ��������ǰ׺Ҫ����ַ������ַ����б�
    // TC: products����Ϊm��searchWord����Ϊn��O(m * n)
    // MC:
    // ִ����ʱ :22 ms, ������ java �ύ�л�����79.32%���û�
    // �ڴ����� :51.4 MB, ������ java �ύ�л�����100.00%���û�

    // �Ż�������һ��ͳ��������ͳ��������3ʱ��������ǰѭ����
    // ִ����ʱ :16 ms, ������ java �ύ�л�����90.66%���û�
    // �ڴ����� :51.9 MB, ������ java �ύ�л�����100.00%���û�
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
                    index.remove();// remove ָ��ǰһ��Ԫ�ء�
                }
            }
            // copy�������list��ansֱ��add stringList����ΪstringList�����ı䣬
            // ���׳�CurrentModificationException
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
