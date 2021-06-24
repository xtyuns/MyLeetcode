package leetcode.editor.cn;
// [剑指 Offer 37] 序列化二叉树
// 2021-06-24 15:14:57

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class XuLieHuaErChaShuLcof {
    // copy method to here
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            if (null == remove) {
                sb.append("null,");
            } else {
                sb.append(remove.val).append(",");
                queue.add(remove.left);
                queue.add(remove.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] split = data.split(",");
        int len = split.length;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);

        for (int i = 1; i < len; i++) {
            TreeNode remove = queue.remove();
            if (!"null".equals(split[i])) {
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                remove.left = node;
                queue.add(node);
            }
            i++;
            if (!"null".equals(split[i])) {
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                remove.right = node;
                queue.add(node);
            }
        }

        return root;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        XuLieHuaErChaShuLcof solution = new XuLieHuaErChaShuLcof();
        solution.debug();
    }
}