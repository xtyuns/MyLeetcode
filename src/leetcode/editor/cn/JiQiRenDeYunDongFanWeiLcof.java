package leetcode.editor.cn;
// [剑指 Offer 13] 机器人的运动范围
// 2021-06-13 20:21:00

public class JiQiRenDeYunDongFanWeiLcof {
    // copy method to here
    // 已访问坐标的标记数组
    boolean[][] visited = null;
    // 可到达的坐标数量
    int count = 0;

    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        // dfs 从左上角开始, 搜索所有坐标
        dfs(m, n, k, 0, 0);
        return this.count;
    }

    private void dfs(int m, int n, int k, int x, int y) {
        int sum = getBitSum(x) + getBitSum(y);
        // 不满足题意、坐标越界、已访问坐标, 都不再向下遍历
        if (sum > k || x >= m || y >= n || visited[x][y]) return;
        // 当前坐标符合题意
        this.count++;
        // 记录为已访问坐标
        visited[x][y] = true;
        // 向右搜索
        dfs(m, n, k, x, y + 1);
        // 向下搜索
        dfs(m, n, k, x + 1, y);
    }

    /**
     * 计算某数字的各数位之和
     */
    private int getBitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public void debug() {
        System.out.println(movingCount(36, 11, 15));
    }

    public static void main(String[] args) {
        JiQiRenDeYunDongFanWeiLcof solution = new JiQiRenDeYunDongFanWeiLcof();
        solution.debug();
    }
}