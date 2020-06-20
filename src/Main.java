import com.ecnu.daily.LRUCache;

import java.util.Random;

public class Main {
    // 实现LRU缓存
    static void testLRUCache() {
        Random random = new Random();
        LRUCache cache = new LRUCache();
        for (int i = 0; i < 20; i ++) {
            cache.add(random.nextInt(13));
        }
    }

    static class Tester {
        char c;// 默认值'\u0000' null
    }
    // Java跳转标签
    // 《Java编程思想》 Page.88
    static void testLabel() {
        int i = 0;
        outer:
        for (; true; ) {
            inner:
            for (; i < 10; i ++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i ++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i ++;
                    continue outer;
                }
                if (i == 8) {
                    System.out.println("break outer");
                    i ++;
                    break outer;
                }
                for (int k = 0; k < 5; k ++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        Tester t = new Tester();
//        System.out.println("hello" + t.c + "world");
//        testLabel();
        testLRUCache();
    }
}
