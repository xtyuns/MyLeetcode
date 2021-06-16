package leetcode.editor.cn;
// [剑指 Offer 22] 链表中倒数第k个节点
// 2021-06-16 21:24:47

import common.ListNode;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    // copy method to here
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        ListNode fast = cur;
        for (int i = 0; i < k; i++) {
            if (null == fast) return null;
            fast = fast.next;
        }

        while (fast != null) {
            cur = cur.next;
            fast = fast.next;
        }

        return cur;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        LianBiaoZhongDaoShuDiKgeJieDianLcof solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof();
        solution.debug();
    }
}