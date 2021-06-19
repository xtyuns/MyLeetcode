package leetcode.editor.cn;
// [剑指 Offer 32 - I] 从上到下打印二叉树
// 2021-06-19 10:44:16

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuLcof {
    // copy method to here
    public int[] levelOrder(TreeNode root) {
        // 实际测试案例中: 节点总数 <= 1009
        int[] ans = new int[1009];
        int cursor = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            if (null == remove) continue;
            queue.add(remove.left);
            queue.add(remove.right);
            ans[cursor++] = remove.val;
        }

        return Arrays.copyOfRange(ans, 0, cursor);
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        CongShangDaoXiaDaYinErChaShuLcof solution = new CongShangDaoXiaDaYinErChaShuLcof();
        solution.debug();
    }
}