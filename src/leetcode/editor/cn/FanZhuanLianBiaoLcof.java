package leetcode.editor.cn;
// [剑指 Offer 24] 反转链表
// 2021-06-16 22:12:08

import common.ListNode;

import java.util.Stack;

public class FanZhuanLianBiaoLcof {
    // copy method to here
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
    
    public void debug() {
        ListNode h = new ListNode(1);
        ListNode cur = h;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = new ListNode(5);

        reverseList(h);
    }

    public static void main(String[] args) {
        FanZhuanLianBiaoLcof solution = new FanZhuanLianBiaoLcof();
        solution.debug();
    }
}