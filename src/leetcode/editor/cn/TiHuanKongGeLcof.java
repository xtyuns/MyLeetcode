package leetcode.editor.cn;
// [剑指 Offer 05] 替换空格
// 2022-01-04 19:41:49

import java.util.Arrays;
import java.util.stream.Collectors;

public class TiHuanKongGeLcof {
  String id = "剑指 Offer 05";
  
  public static void main(String[] args) {
      Solution solution = new TiHuanKongGeLcof().new Solution();
      System.out.println(solution.replaceSpace("    "));
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * s.replace(" ", "%20") 效率更高
     */
    public String replaceSpace(String s) {
        String[] strings = s.split("");
        return Arrays.stream(strings)
                .map(str -> " ".equals(str) ? "%20" : str)
                .collect(Collectors.joining());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}