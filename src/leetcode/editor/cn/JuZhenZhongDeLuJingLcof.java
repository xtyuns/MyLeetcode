package leetcode.editor.cn;
// [剑指 Offer 12] 矩阵中的路径
// 2021-06-13 19:55:47

public class JuZhenZhongDeLuJingLcof {
    // copy method to here
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) return word.length() == 0;
        int cols = board[0].length;

        // 任何一个坐标都有可能是起点
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int k) {
        // k: 已找到的字符数量
        if (k == word.length()) return true;
        // 坐标越界或者当前坐标上不是预期字符, 无需在该分支上继续查找(剪枝)
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(k)) {
            return false;
        }
        // 当前坐标字符已遍历过, 标记
        board[x][y] = '\0';
        // dfs 在当前坐标的四个方向上继续向下查找结果
        boolean flag = dfs(board, word, x - 1, y, k + 1) || dfs(board, word, x + 1, y, k + 1)
                || dfs(board, word, x, y - 1, k + 1) || dfs(board, word, x, y + 1, k + 1);
        // 回溯, 防止影响其他 dfs
        board[x][y] = word.charAt(k);

        return flag;
    }

    public void debug() {

    }

    public static void main(String[] args) {
        JuZhenZhongDeLuJingLcof solution = new JuZhenZhongDeLuJingLcof();
        solution.debug();
    }
}