package leetcode.editor.cn;
// [剑指 Offer 32 - III] 从上到下打印二叉树 III
// 2021-06-20 09:46:16

import common.TreeNode;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    // copy method to here
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            int size = queue.size();

            // 从左到右打印
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                integers.add(treeNode.val);

                if (null != treeNode.left) queue.addLast(treeNode.left);
                if (null != treeNode.right) queue.addLast(treeNode.right);
            }
            ans.add(integers);

            // 从右到左打印
            size = queue.size();
            if (size == 0) break;
            integers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeLast();
                integers.add(treeNode.val);

                if (null != treeNode.right) queue.addFirst(treeNode.right);
                if (null != treeNode.left) queue.addFirst(treeNode.left);
            }
            ans.add(integers);
        }

        return ans;
    }
    
    public void debug() {
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        t3.right = new TreeNode(5);
        TreeNode root = new TreeNode(1);
        root.left = t2;
        root.right = t3;
        levelOrder(root);
    }

    public static void main(String[] args) {
        CongShangDaoXiaDaYinErChaShuIiiLcof solution = new CongShangDaoXiaDaYinErChaShuIiiLcof();
        solution.debug();
    }
}