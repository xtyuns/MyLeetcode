package leetcode.editor.cn;
// [剑指 Offer 26] 树的子结构
// 2021-06-17 15:12:54

import common.TreeNode;

public class ShuDeZiJieGouLcof {
    // copy method to here
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) return false;
        if (A.val == B.val && isEq(A.left, B.left) && isEq(A.right, B.right)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isEq(TreeNode tree1, TreeNode tree2) {
        // 子树的所有节点递归判断相等了, 则返回真, 否则返回假
        if (null == tree1 || null == tree2) return null == tree2;
        // 先序遍历
        return tree1.val == tree2.val && isEq(tree1.left, tree2.left) && isEq(tree1.right, tree2.right);
    }

    public void debug() {

    }

    public static void main(String[] args) {
        ShuDeZiJieGouLcof solution = new ShuDeZiJieGouLcof();
        solution.debug();
    }
}