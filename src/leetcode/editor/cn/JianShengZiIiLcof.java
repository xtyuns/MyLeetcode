package leetcode.editor.cn;
// [剑指 Offer 14- II] 剪绳子 II
// 2021-06-14 15:41:55

public class JianShengZiIiLcof {
    // copy method to here
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int r = (int) (1e9+7);

        // 1. (a * b) % r = (a % r) * (b % r) % r
        // 2. ans 取余前可能大于 Integer.MAX_VALUE，所以要使用 long 防止溢出
        long ans = 1;
        // 每段都剪为长度为 3 的绳子, 当最后一段的长度为 4 时就不再剪断了
        while (n > 4) {
            ans = ans * 3 % r;
            n -= 3;
        }
        return (int) (ans * n % r);
    }
    
    public void debug() {
        System.out.println(cuttingRope(120));
    }

    public static void main(String[] args) {
        JianShengZiIiLcof solution = new JianShengZiIiLcof();
        solution.debug();
    }
}