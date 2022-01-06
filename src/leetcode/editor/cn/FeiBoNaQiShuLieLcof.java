package leetcode.editor.cn;
// [剑指 Offer 10- I] 斐波那契数列
// 2022-01-06 21:07:07

public class FeiBoNaQiShuLieLcof {
  String id = "剑指 Offer 10- I";
  
  public static void main(String[] args) {
      Solution solution = new FeiBoNaQiShuLieLcof().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if (n < 2) return n;

        // 传统递归会超时, 因此需要将子问题的结果存入字典
        // 又因为斐波那契只依赖前两个子问题的结果, 所以这里可以优化掉没有意义的额外空间
        // 过程中的循环取余是核心, 要保证数据不会出现溢出的情况
        // (a + b) % c == (a % c + b % c) % c
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
            // 虽然在上面 b 的值可能会高于 1000000007, 但是接下来的取余调整会使 b 的值小于 1000000007
            // 则可以保证在下一轮中 b + b 永远不会溢出, 因为 b + b 的值不可能达到 2 * 1000000007
            // 因此 b = a + b 永远不会溢出 (因为 a 是 b 在上一轮循环中的值)
            // 当 b 不发生溢出时, a = a + b - a 也一定不会出现溢出导致的数据错误, 因此可以保证结果的正确性
            b %= 1000000007;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}