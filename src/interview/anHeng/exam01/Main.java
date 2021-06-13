package heng.exam01;

import java.util.LinkedList;
import java.util.Scanner;

class Node {
    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value +  "" + (null == next ? "" : "->" + next);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] txts = in.nextLine().split(", ");

        // 构造链表1
        Node list1 = new Node();
        Node cur = list1;
        for (String s : txts[0].split("->")) {
            cur.next = new Node(Integer.parseInt(s), null);
            cur = cur.next;
        }

        // 构造链表2
        Node list2 = new Node();
        cur = list2;
        for (String s : txts[1].split("->")) {
            cur.next = new Node(Integer.parseInt(s), null);
            cur = cur.next;
        }

        Node pre = list1;
        cur = list1.next;
        Node cur2 = list2.next;
        while (null != cur && null != cur2) {
            if (cur.value > cur2.value) {
                pre.next = cur2;
                cur2 = cur2.next;
                pre = pre.next;
                pre.next = cur;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        if (null == cur && null != cur2) {
            pre.next = cur2;
        }
        System.out.println(list1.next);
    }
}
