package leetcode.editor.cn;
// [剑指 Offer 17] 打印从1到最大的n位数
// 2021-06-15 15:00:35

public class DaYinCong1daoZuiDaDeNweiShuLcof {
    // copy method to here
    public int[] printNumbers(int n) {
        int len = (int) (Math.pow(10, n) - 1);
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = i + 1;
        }

        return nums;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        DaYinCong1daoZuiDaDeNweiShuLcof solution = new DaYinCong1daoZuiDaDeNweiShuLcof();
        solution.debug();
    }
}