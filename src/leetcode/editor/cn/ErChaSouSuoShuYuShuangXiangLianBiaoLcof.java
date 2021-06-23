package leetcode.editor.cn;
// [剑指 Offer 36] 二叉搜索树与双向链表
// 2021-06-23 14:33:48

import common.Node;

public class ErChaSouSuoShuYuShuangXiangLianBiaoLcof {
    // copy method to here
    // 解题的关键: head 节点的初始化以及使用 pre 变量保存前一个节点
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (null == root) return null;
        dfs(root);

        // 调整第一个节点的前序指针以及最后一个节点的后序指针
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node root) {
        if (null == root) return;
        dfs(root.left);

        // 第一个节点时进行 head 变量的初始化(同时 pre 变量也会进行更新)
        if (null == head) {
            head = root;
        } else {  // 调整当前节点的前序指针以及 pre 节点的后序指针
            root.left = pre;
            pre.right = root;
        }
        pre = root;

        dfs(root.right);
    }


    public void debug() {

    }

    public static void main(String[] args) {
        ErChaSouSuoShuYuShuangXiangLianBiaoLcof solution = new ErChaSouSuoShuYuShuangXiangLianBiaoLcof();
        solution.debug();
    }
}