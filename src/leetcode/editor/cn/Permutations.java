package leetcode.editor.cn;
// [46] 全排列
// 2022-01-03 19:23:02

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
  int id = 46;
  
  public static void main(String[] args) {
      Solution solution = new Permutations().new Solution();
      System.out.println(solution.permute(new int[]{1, 2, 3}));
  }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (null == nums) return Collections.emptyList();
            return recur(Arrays.stream(nums).boxed().collect(Collectors.toList()), 0);
        }

        private List<List<Integer>> recur(List<Integer> nums, int index) {
            List<List<Integer>> ans = new ArrayList<>();
            if (index == nums.size()) {
                // copy value
                ans.add(new ArrayList<>(nums));
                return ans;
            }

            // back track
            for (int i = index; i < nums.size(); i++) {
                Collections.swap(nums, index, i);
                ans.addAll(recur(nums, index + 1));
                Collections.swap(nums, index, i);
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}