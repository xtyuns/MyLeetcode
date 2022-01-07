package leetcode.editor.cn;
// [剑指 Offer 11] 旋转数组的最小数字
// 2022-01-07 20:12:20

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
  String id = "剑指 Offer 11";
  
  public static void main(String[] args) {
      Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
  }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        // 因为数组是从递增进行的反转, 因此找到水位下落的转折点即为反转前的起点
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}