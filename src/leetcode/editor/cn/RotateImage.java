package leetcode.editor.cn;
// [48] 旋转图像
// 2022-02-27 11:49:44

import java.util.Arrays;

public class RotateImage {
  int id = 48;
  
  public static void main(String[] args) {
      Solution solution = new RotateImage().new Solution();
      int[][] arr = {
              {1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}
      };
      solution.rotate(arr);
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || null == matrix[0]) return;
        // $ 作为形参表示这里不关心入参内容
        int[][] dict = Arrays.stream(matrix).map(int[]::clone).toArray($-> matrix.clone());

        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // (i, j) => (m, n)
                int m = j;
                int n = cols - 1 - i;
                matrix[m][n] = dict[i][j];
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}