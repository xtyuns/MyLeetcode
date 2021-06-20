package leetcode.editor.cn;
// [剑指 Offer 33] 二叉搜索树的后序遍历序列
// 2021-06-20 15:46:52

import java.util.Stack;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    // copy method to here
    public boolean verifyPostorder(int[] postorder) {
        if (null == postorder) return false;
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int m = i;
        // 左子树的所有节点都小于根节点
        while (postorder[m] < postorder[j]) m++;
        // 判断右子树是否都大于根节点
        int n = m;
        while (postorder[n] > postorder[j]) n++;
        return n == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public void debug() {

    }

    public static void main(String[] args) {
        ErChaSouSuoShuDeHouXuBianLiXuLieLcof solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof();
        solution.debug();
    }
}