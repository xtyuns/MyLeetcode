package leetcode.editor.cn;
// [剑指 Offer 42] 连续子数组的最大和
// 2021-07-09 10:25:13

public class LianXuZiShuZuDeZuiDaHeLcof {
    // copy method to here
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int mem = nums[0], max = mem;
        for (int i = 1, len = nums.length; i < len; i++) {
            // mem 记录的是以元素 nums[i] 为结尾的连续子数组最大和(为了保证遍历 nums[i+1] 时的连续性, 因此 nums[i] 的值必须计算在内, 动态规划优化为贪心)
            mem = mem > 0 ? mem + nums[i] : nums[i];
            // max 记录整个数组中的最大子数组之和
            max = Math.max(max, mem);
        }

        return max;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        LianXuZiShuZuDeZuiDaHeLcof solution = new LianXuZiShuZuDeZuiDaHeLcof();
        solution.debug();
    }
}