package leetcode.editor.cn;
// [剑指 Offer 04] 二维数组中的查找
// 2021-06-12 10:20:55

public class ErWeiShuZuZhongDeChaZhaoLcof {
    // copy method to here
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean flag = false;
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                flag = true;
                break;
            }
        }

        return flag;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        ErWeiShuZuZhongDeChaZhaoLcof solution = new ErWeiShuZuZhongDeChaZhaoLcof();
        solution.debug();
    }
}