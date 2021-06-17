package leetcode.editor.cn;
// [剑指 Offer 25] 合并两个排序的链表
// 2021-06-17 09:24:51

import common.ListNode;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
    // copy method to here
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        HeBingLiangGePaiXuDeLianBiaoLcof solution = new HeBingLiangGePaiXuDeLianBiaoLcof();
        solution.debug();
    }
}