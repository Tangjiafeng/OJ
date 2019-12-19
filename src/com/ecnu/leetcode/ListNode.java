package com.ecnu.leetcode;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        
        return null;
    }
    // https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
    // ע�⴦��߽�������
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
//        ListNode listNode = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode4.next = listNode5;
//        listNode3.next = listNode4;
//        listNode2.next = listNode3;
//        listNode.next = listNode2;
//
//        listNode.print();
//        listNode.removeNthFromEnd(listNode, 2);
//        listNode.print();
    }

}
