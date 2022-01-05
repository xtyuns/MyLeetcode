package leetcode.editor.cn;
// [剑指 Offer 07] 重建二叉树
// 2022-01-04 20:25:14

import common.TreeNode;

import java.util.HashMap;

public class ZhongJianErChaShuLcof {
  String id = "剑指 Offer 07";
  
  public static void main(String[] args) {
      Solution solution = new ZhongJianErChaShuLcof().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length == 0)
            return null;
        if (preorder.length != inorder.length)
            throw new IllegalArgumentException("Unexpect Args");

        // 使用 hashmap 保存中序索引, 优化遍历获取索引的开销
        HashMap<Integer, Integer> midIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            midIdxMap.put(inorder[i], i);
        }

        return recur(preorder, midIdxMap, 0, 0, preorder.length);
    }

    private TreeNode recur(int[] preorder, HashMap<Integer, Integer> midIdxMap,
                           int rootPreIdx, int midLeft, int midRight) {
        // 如果中序集合的左右边界不正常, 则说明该节点是不存在的
        if (midLeft >= midRight) return null;

        // 构建当前根节点
        int cur = preorder[rootPreIdx];
        TreeNode head = new TreeNode(cur);

        // 根据先序遍历和中序遍历的特点递归构造左右子树
        int curMidIdx = midIdxMap.get(cur);
        head.left = recur(preorder, midIdxMap, rootPreIdx + 1, midLeft, curMidIdx);
        // 这里的 rootPreIdx 需要减去 midLeft, 因为 curMidIdx 中包含了父节点中的节点, 所以这里以 midLeft 为参考原点
        head.right = recur(preorder, midIdxMap, rootPreIdx + 1 + (curMidIdx - midLeft), curMidIdx + 1, midRight);

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}