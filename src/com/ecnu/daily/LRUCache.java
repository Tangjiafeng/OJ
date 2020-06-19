package com.ecnu.daily;

import java.util.LinkedList;
import java.util.List;

/**
 * ֵ��ע��ĵط�
 * ���棬Ҫ�����̰߳�ȫ
 * ����Ĵ�С���û�ָ��
 * ����Ԫ��Ӧ�����û�ָ�������뷺�͵Ĵ���
 *
 */
public class LRUCache {
    // ��ʵ�֣�û�п���contains��Ч�ʣ�����������
    List<Integer> queue = new LinkedList<>();
    int size = 8;

    public void add(Integer e) {
        if (queue.size() < size) {
            if (queue.contains(e)) {
                queue.remove(e);
            }
        } else {
            if (queue.contains(e)) {
                queue.remove(e);
            } else {
                queue.remove(0);
            }
        }
        queue.add(e);
    }
}
