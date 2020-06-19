package com.ecnu.daily;

import java.util.LinkedList;
import java.util.List;

/**
 * 值得注意的地方
 * 缓存，要考虑线程安全
 * 缓存的大小由用户指定
 * 缓存元素应该由用户指定，加入泛型的处理
 *
 */
public class LRUCache {
    // 简单实现，没有考虑contains的效率，即遍历链表
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
