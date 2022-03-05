package leetcode.editor.cn;
// [5] 最长回文子串
// 2022-03-05 17:42:23

public class LongestPalindromicSubstring {
    int id = 5;

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("ababd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 中心扩展法求最长回文串 O(n²), 最坏情况: 字符串中所有字符都相同
        public String longestPalindrome(String s) {
            // 最长回文串的长度
            int max = 1;
            // 最长回文串的起点坐标
            int start = 0;

            for (int i = 0; i < s.length(); i++) {
                // 以当前位置为中心坐标的奇数回文串最大长度
                int oddLen = getMaxPalindromeLength(s, i, i);
                // 以当前位置为中心坐标的偶数回文串最大长度
                int evenLen = getMaxPalindromeLength(s, i, i + 1);

                // 更新最长回文串的起点索引和长度
                if (oddLen >= max && oddLen > evenLen) {
                    // 当前位置减去回文串的一半即为起点坐标
                    start = i - (oddLen - 1) / 2;
                    max = oddLen;
                } else if (evenLen >= max && evenLen > oddLen) {
                    start = (i + 1) - evenLen / 2;
                    max = evenLen;
                }
            }
            return s.substring(start, start + max);
        }

        /**
         * 获取字符串 s 中以 (i,j) 索引作为回文子串中心的最大回文串长度
         *
         * @param s 待求最大回文串长度的字符串
         * @param i 回文串的中心坐标 1
         * @param j 回文串的中心坐标 2 (坐标1 == 坐标2 时表示回文串的长度时奇数, 坐标1 == 坐标2 + 1 时表示回文串的长度是偶数)
         * @return 字符串 s 中最长回文串的长度
         */
        private int getMaxPalindromeLength(String s, int i, int j) {
            while (i >= 0 && j < s.length()) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
                // 向两侧延展子串
                i--;
                j++;
            }
            // [i, j] 内侧为回文串(不包含 i,j), 返回它们的长度
            return j - i - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}