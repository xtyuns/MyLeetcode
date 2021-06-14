package leetcode.editor.cn;
// [剑指 Offer 14- I] 剪绳子
// 2021-06-14 09:51:00

public class JianShengZiLcof {
    // copy method to here
    public int cuttingRope(int n) {
        if (n < 4) return n-1;
        int[] dp = new int[n + 1];
        for (int i = 1; i < 4; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            for (int j = 0; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }

        return dp[n];
    }
    
    public void debug() {
        System.out.println(cuttingRope(10));
    }

    public static void main(String[] args) {
        JianShengZiLcof solution = new JianShengZiLcof();
        solution.debug();
    }
}