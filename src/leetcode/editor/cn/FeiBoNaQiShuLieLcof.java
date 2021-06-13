package leetcode.editor.cn;
// [剑指 Offer 10- I] 斐波那契数列
// 2021-06-13 08:58:31

public class FeiBoNaQiShuLieLcof {
    // copy method to here
    public int fib(int n) {
        // cur 为 f(n) 的前一个值
        int pre = 0, cur = 1, next = n;
        for (int i = 1; i < n; i++) {
            next = (pre + cur) % 1000000007;
            pre = cur;
            cur = next;
        }

        return next;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        FeiBoNaQiShuLieLcof solution = new FeiBoNaQiShuLieLcof();
        solution.debug();
    }
}