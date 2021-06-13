package leetcode.editor.cn;
// [剑指 Offer 11] 旋转数组的最小数字
// 2021-06-13 15:00:17

public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    // copy method to here
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] > numbers[high]) {  // mid 大于 high, 说明最小值在右侧且 mid 位置必定不可能为最小值
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {  // mid 小于 high, 说明最小值一定在左侧(数组递增)
                high = mid;
            } else {  // mid 等于 high, 无法确定最小值的位置, 进一步缩小问题 ([2,2,2,1,2] 和 [1,2,2,2,2])
                high--;
            }
        }

        return numbers[low];
    }

    public void debug() {
        int[] s = new int[]{2,2,2,0,1};
        minArray(s);
    }

    public static void main(String[] args) {
        XuanZhuanShuZuDeZuiXiaoShuZiLcof solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof();
        solution.debug();
    }
}