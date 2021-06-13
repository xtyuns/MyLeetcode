package leetcode.editor.cn;
// [剑指 Offer 07] 重建二叉树
// 2021-06-12 20:27:24

import common.TreeNode;

import java.util.*;

public class ZhongJianErChaShuLcof {
    // copy method to here
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[0]);
        int left_length = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                left_length = i;
                break;
            }
        }

        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + left_length), Arrays.copyOfRange(inorder, 0, left_length));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, 1 + left_length, preorder.length), Arrays.copyOfRange(inorder, left_length + 1, inorder.length));
        return treeNode;
    }

    private List<int[]> splitArr(int[] preorder, int i) {
        List<int[]> result = new ArrayList<>();
        for (int i1 = 0; i1 < preorder.length; i1++) {
            if (preorder[i1] == i) {
                result.add(Arrays.copyOfRange(preorder, 0, i1));
                result.add(Arrays.copyOfRange(preorder, i1 + 1, preorder.length));
                break;
            }
        }

        return result;
    }

    public void debug() {
        int[] p = new int[]{3, 9, 20, 15, 7};
        int[] i = new int[]{9,3,15,20,7};
        buildTree(p, i);
    }

    public static void main(String[] args) {
        ZhongJianErChaShuLcof solution = new ZhongJianErChaShuLcof();
        solution.debug();
    }
}