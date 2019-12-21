package com.ecnu.leetcode;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println("null");
    }
    // https://leetcode-cn.com/problems/reverse-linked-list/
    // 保存后继元素，反转前驱元素
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode backNode = head.next.next;
        ListNode originHead = head;
        head = head.next;
        head.next = originHead;
        head.next.next = null;
        while (backNode != null) {
            ListNode tempNode = backNode;
            backNode = backNode.next;
            tempNode.next = head;
            head = tempNode;
        }
        return head;
    }
    // https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
    // 注意处理边界条件。
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        while(n >= 0) {
            q = q.next;
            n --;
        }
        while(q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;

        listNode.print();
        ListNode.removeNthFromEnd(listNode, 2);
        listNode.print();

        listNode.print();
        // 第一个节点作为参数传入，效果是五个节点的next指向都被反转了。
        // 函数只能修改next指向，listNode本身还是指向值为1的元素。
        ListNode.reverseList(listNode).print();
        listNode.print();// 第一个节点变成了倒数一个节点，所以打印出来：1->null
    }
}
