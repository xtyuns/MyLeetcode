package leetcode.editor.cn;
// [剑指 Offer 39] 数组中出现次数超过一半的数字
// 2021-07-01 09:32:58

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    // copy method to here
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 0;
        for (int num : nums) {
            // ans 为当前认可的众数, 遇到同伴数字, 则计数+1
            if (num == ans) count++;
            else if (count == 0) {  // ans 的计数为0, 重置 ans 的值
                ans = num;
                count++;
            } else {  // ans 的计数大于 0, 遇到非同伴数字, 计数-1
                count--;
            }
        }
        return ans;
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof();
        solution.debug();
    }
}