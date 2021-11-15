package leetcode.editor.cn;
// [319] 灯泡开关
// 2021-11-15 21:03:36

public class BulbSwitcher{
  public static void main(String[] args) {
      Solution solution = new Solution();
      System.out.println(solution.bulbSwitch(6));
  }
}


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 1. 只有当位置 i 上的状态被切换了奇数次时, 该灯的最终状态才为亮灯
 * 2. 灯的切换次数等于该位置所对应数字的因子个数
 * 3. 只有平方数的因子为奇数个, 其他情况下因子都是成对存在的
 * 4. 数字 1 到 n 的平方数的数量等于 n 的正平方根取整
 */
class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

