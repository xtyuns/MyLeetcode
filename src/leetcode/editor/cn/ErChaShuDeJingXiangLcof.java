package leetcode.editor.cn;
// [剑指 Offer 27] 二叉树的镜像
// 2021-06-17 15:36:37

import common.TreeNode;

public class ErChaShuDeJingXiangLcof {
    // copy method to here
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        ErChaShuDeJingXiangLcof solution = new ErChaShuDeJingXiangLcof();
        solution.debug();
    }
}