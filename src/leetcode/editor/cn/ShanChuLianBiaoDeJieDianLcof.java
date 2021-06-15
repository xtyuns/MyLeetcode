package leetcode.editor.cn;
// [剑指 Offer 18] 删除链表的节点
// 2021-06-15 16:35:01

import common.ListNode;

public class ShanChuLianBiaoDeJieDianLcof {
    // copy method to here
    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) return null;
        if (head.val == val) return head.next;
        else head.next = deleteNode(head.next, val);

        return head;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        ShanChuLianBiaoDeJieDianLcof solution = new ShanChuLianBiaoDeJieDianLcof();
        solution.debug();
    }
}