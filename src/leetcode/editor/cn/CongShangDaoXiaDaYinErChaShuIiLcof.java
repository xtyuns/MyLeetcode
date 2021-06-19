package leetcode.editor.cn;
// [剑指 Offer 32 - II] 从上到下打印二叉树 II
// 2021-06-19 11:13:08

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiLcof {
    // copy method to here
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 递归实现二叉树的二维数组格式层序遍历
        // i 代表目前正在遍历的层数(从0开始)
        recur(root, 0);
        return ans;
    }

    private void recur(TreeNode root, int i) {
        if (null == root) return;
        // 初始化第 i 层的列表
        if (i == ans.size()) ans.add(new ArrayList<>());
        // 放置到对应的二维数组中
        ans.get(i).add(root.val);
        // 左右分别递归执行 i+1 层
        recur(root.left, i + 1);
        recur(root.right, i + 1);
    }

    public void debug() {

    }

    public static void main(String[] args) {
        CongShangDaoXiaDaYinErChaShuIiLcof solution = new CongShangDaoXiaDaYinErChaShuIiLcof();
        solution.debug();
    }
}