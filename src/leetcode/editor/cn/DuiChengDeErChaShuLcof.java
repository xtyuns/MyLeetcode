package leetcode.editor.cn;
// [剑指 Offer 28] 对称的二叉树
// 2021-06-17 15:48:59

import common.TreeNode;

public class DuiChengDeErChaShuLcof {
    // copy method to here
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return isImg(root.left, root.right);
    }

    private boolean isImg(TreeNode left, TreeNode right) {
        if (null == left || null == right) return left == right;
        return left.val == right.val && isImg(left.left, right.right) && isImg(left.right, right.left);
    }


    public void debug() {

    }

    public static void main(String[] args) {
        DuiChengDeErChaShuLcof solution = new DuiChengDeErChaShuLcof();
        solution.debug();
    }
}