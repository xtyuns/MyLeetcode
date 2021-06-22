package leetcode.editor.cn;
// [剑指 Offer 35] 复杂链表的复制
// 2021-06-22 20:24:09

import common.randomNode.Node;

import java.util.HashMap;
import java.util.Map;

public class FuZaLianBiaoDeFuZhiLcof {
    // copy method to here
    // 深拷贝
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;

        // 先拷贝一份 Node 的 val 的 map
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node tmp = map.get(cur);
            tmp.next = map.get(cur.next);
            tmp.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        FuZaLianBiaoDeFuZhiLcof solution = new FuZaLianBiaoDeFuZhiLcof();
        solution.debug();
    }
}