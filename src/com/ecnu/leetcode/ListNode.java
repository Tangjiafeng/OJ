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
    // ������Ԫ�أ���תǰ��Ԫ��
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
    // ע�⴦��߽�������
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
        // ��һ���ڵ���Ϊ�������룬Ч��������ڵ��nextָ�򶼱���ת�ˡ�
        // ����ֻ���޸�nextָ��listNode������ָ��ֵΪ1��Ԫ�ء�
        ListNode.reverseList(listNode).print();
        listNode.print();// ��һ���ڵ����˵���һ���ڵ㣬���Դ�ӡ������1->null
    }
}
