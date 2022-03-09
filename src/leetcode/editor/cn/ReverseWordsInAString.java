package leetcode.editor.cn;
// [151] 翻转字符串里的单词
// 2022-03-06 19:56:15

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAString {
  int id = 151;
  
  public static void main(String[] args) {
      Solution solution = new ReverseWordsInAString().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        return Arrays.stream(s1.split(" "))
                .filter(str -> str.trim().length() > 0)
                .map(str -> new StringBuilder(str).reverse())
                .collect(Collectors.joining(" "));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}