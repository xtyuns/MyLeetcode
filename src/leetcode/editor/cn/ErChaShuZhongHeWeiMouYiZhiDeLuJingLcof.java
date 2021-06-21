package leetcode.editor.cn;
// [剑指 Offer 34] 二叉树中和为某一值的路径
// 2021-06-21 13:58:11

import common.TreeNode;

import java.util.*;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    // copy method to here

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return ans;
    }

    private void recur(TreeNode root, int target) {
        // 因为节点中存在负数, 所以需要一直dfs遍历到叶子节点, 无法通过 target < 0 进行剪枝
        if (null == root) return;

        path.add(root.val);
        target -= root.val;

        // 是否为满足条件的路径, 从根 -> 叶子
        if (target == 0 && null == root.left && null == root.right)
            // 拷贝到新列表, 消除 path 列表因引用传递对 ans 中二级列表的影响
            ans.add(new ArrayList<>(path));

        // dfs递归左右子树
        recur(root.left, target);
        recur(root.right, target);

        // 回溯
        path.removeLast();
    }

    public void debug() {

    }

    public static void main(String[] args) {
        ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof();
        solution.debug();
    }
}