package leetcode.editor.cn;
// [剑指 Offer 06] 从尾到头打印链表
// 2021-06-12 17:10:16

import common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    // copy method to here
    public int[] reversePrint(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] ints = new int[size];
        for (int i = size; i > 0; i--) {
            ints[i - 1] = head.val;
            head = head.next;
        }

        return ints;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        CongWeiDaoTouDaYinLianBiaoLcof solution = new CongWeiDaoTouDaYinLianBiaoLcof();
        solution.debug();
    }
}