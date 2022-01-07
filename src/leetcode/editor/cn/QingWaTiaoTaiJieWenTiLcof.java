package leetcode.editor.cn;
// [剑指 Offer 10- II] 青蛙跳台阶问题
// 2022-01-07 20:01:20

public class QingWaTiaoTaiJieWenTiLcof {
  String id = "剑指 Offer 10- II";
  
  public static void main(String[] args) {
      Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        // 与斐波那契数列同理, 跳到 n-1 台阶上再跳一层即可, 或跳到 n-2 台阶上再跳两层即可, 只要求出来到达 n-1 和 n-2 台阶的情况总和即可
        // 因此 f(n) = f(n-1) + f(n-2)
        // 根据《剑指 Offer 10- I 》相同的字典优化方案实现代码如下
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
            b  %= 1000000007;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}