package leetcode.editor.cn;
// [剑指 Offer 21] 调整数组顺序使奇数位于偶数前面
// 2021-06-15 23:10:49

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    // copy method to here
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            while (l < r) {
                if (nums[l] % 2 == 1) l++;
                else break;
            }
            while (l < r) {
                if (nums[r] % 2 == 0) r--;
                else break;
            }

            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        return nums;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof();
        solution.debug();
    }
}