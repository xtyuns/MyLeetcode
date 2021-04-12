package common;

// 链表节点类
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String str = String.valueOf(val);
        str += next == null ? "" : "->" + next;
        return str;
    }
}