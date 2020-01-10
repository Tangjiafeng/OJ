package com.ecnu.leetcode;
// TC:
// MC:
// ִ����ʱ : ms, ������ java �ύ�л�����%���û�
// �ڴ����� : MB, ������ java �ύ�л�����%���û�
import java.util.Stack;

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
    // https://leetcode-cn.com/problems/linked-list-cycle/
    // Algor of mine: ����ָ�뷨��ע���ָ��ǰ��������ʱ���ж��Ƿ�Ϊnull��
    // ִ����ʱ : 37 ms, ������ java �ύ�л����� 100% ���û�
    // �ڴ����� : 37.3 MB, ������ java �ύ�л����� 96.95% ���û�
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return Boolean.FALSE;
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return Boolean.TRUE;
            }
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                break;
            }
        }
        return Boolean.FALSE;
    }
    // https://leetcode-cn.com/problems/palindrome-linked-list/
    // Algor of mine: ����ջ�����Դ洢һ��Ԫ�����Ƚϡ�
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        // Length
        int len = 0;
        ListNode p = new ListNode(0);
        p.next = head;
        p = p.next;
        while (p != null) {
            len ++;
            p = p.next;
        }
        // The left half is put on the stack and compared with the right half.
        for (int i = 0; i < len / 2; i ++) {
            stack.push(head.val);
            head = head.next;
        }
        if (len % 2 != 0) {
            head = head.next;
        }
        while (! stack.isEmpty()) {
            if (stack.pop() == head.val) {
                head = head.next;
                continue;
            } else {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
    // Algor 1: һ�ֿ���ָ������������ÿ���ָ���ҵ���������λ�ã����ڱ����з�ת��벿��������Ԫ�رȽϡ�
    // TC: O(1)
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return Boolean.TRUE;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        ListNode prepre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return Boolean.FALSE;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return Boolean.TRUE;
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
        /*
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
        ListNode.reverseList(listNode).print();
        listNode.print();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(1);
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        listNode.print();
        System.out.println(isPalindrome(listNode));
        */
    }
}