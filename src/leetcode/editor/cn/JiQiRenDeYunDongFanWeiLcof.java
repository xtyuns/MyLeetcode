package leetcode.editor.cn;
// [剑指 Offer 13] 机器人的运动范围
// 2021-06-13 20:21:00

public class JiQiRenDeYunDongFanWeiLcof {
    // copy method to here
    public int movingCount(int m, int n, int k) {
        boolean[][] mark = new boolean[m][n];
        return dfs(m, n, k, 0, 0, 0, mark);
    }

    private int dfs(int m, int n, int k, int x, int y, int count, boolean[][] mark) {
        int sum = getBitSum(x) + getBitSum(y);
        if (sum > k || x >= m || y >= n) return count;
        if (!mark[x][y]) {
            mark[x][y] = true;
            count++;
        }
        count = dfs(m, n, k, x, y + 1, count, mark) + dfs(m, n, k, x + 1, y, count, mark);


        return count;
    }

    private int getBitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public void debug() {

    }

    public static void main(String[] args) {
        JiQiRenDeYunDongFanWeiLcof solution = new JiQiRenDeYunDongFanWeiLcof();
        solution.debug();
    }
}