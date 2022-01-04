package leetcode.editor.cn;
// [剑指 Offer 06] 从尾到头打印链表
// 2022-01-04 19:58:51

import common.ListNode;

import java.util.Arrays;

public class CongWeiDaoTouDaYinLianBiaoLcof {
  String id = "剑指 Offer 06";
  
  public static void main(String[] args) {
      Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 递归, 需要频繁的空间开销操作, 不如上次提交的代码效率高
     */
    public int[] reversePrint(ListNode head) {
        if (null == head) return new int[0];
        int[] before = reversePrint(head.next);
        int[] ans = Arrays.copyOf(before, before.length + 1);
        ans[ans.length - 1] = head.val;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}