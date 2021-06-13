package leetcode.editor.cn;
// [剑指 Offer 10- II] 青蛙跳台阶问题
// 2021-06-13 14:33:00

public class QingWaTiaoTaiJieWenTiLcof {
    // copy method to here
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
        }

        return dp[n];
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        QingWaTiaoTaiJieWenTiLcof solution = new QingWaTiaoTaiJieWenTiLcof();
        solution.debug();
    }
}