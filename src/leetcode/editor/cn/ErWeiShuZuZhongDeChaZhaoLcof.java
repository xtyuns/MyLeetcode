package leetcode.editor.cn;
// [剑指 Offer 04] 二维数组中的查找
// 2022-01-04 19:07:54

public class ErWeiShuZuZhongDeChaZhaoLcof {
  String id = "剑指 Offer 04";
  
  public static void main(String[] args) {
      Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
  }
  
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0)
                return false;
            int row = matrix.length;
            int col = matrix[0].length;

            // 从右上角可以将二维数组看作是一个二叉搜索树
            int x = 0;
            int y = col - 1;
            while (x < row && y >= 0) {
                int cur = matrix[x][y];
                if (cur == target) return true;
                if (cur > target) y--;
                else x++;
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}