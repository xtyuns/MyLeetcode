package leetcode.editor.cn;
// [剑指 Offer 29] 顺时针打印矩阵
// 2021-06-17 20:28:54

import java.util.Arrays;

public class ShunShiZhenDaYinJuZhenLcof {
    // copy method to here
    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return new int[0];

        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int size = (right + 1) * (bottom + 1);

        int[] ans = new int[size];
        int point = 0;
        while (point < size) {
            // 从左上向右上遍历
            for (int i = left; i <= right; i++) {
                ans[point++] = matrix[top][i];
            }
            if (top++ == bottom) break;
            // 从右上向右下遍历
            for (int i = top; i <= bottom; i++) {
                ans[point++] = matrix[i][right];
            }
            if (right-- == left) break;
            // 从下右向下左遍历
            for (int i = right; i >= left; i--) {
                ans[point++] = matrix[bottom][i];
            }
            if (bottom-- == top) break;
            // 从左下向左上遍历
            for (int i = bottom; i >= top; i--) {
                ans[point++] = matrix[i][left];
            }
            left++;
        }

        return ans;
    }
    
    public void debug() {
        int[][] test = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(spiralOrder(test)));
    }

    public static void main(String[] args) {
        ShunShiZhenDaYinJuZhenLcof solution = new ShunShiZhenDaYinJuZhenLcof();
        solution.debug();
    }
}