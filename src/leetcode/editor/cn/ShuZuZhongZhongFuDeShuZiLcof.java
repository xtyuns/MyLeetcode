package leetcode.editor.cn;
// [剑指 Offer 03] 数组中重复的数字
// 2021-06-12 09:41:27

public class ShuZuZhongZhongFuDeShuZiLcof {
    // copy method to here
    public int findRepeatNumber(int[] nums) {
        int repeat = -1;
        for (int i = 0, len = nums.length; i < len; i++) {
            // 自己在家
            if (nums[i] == i) {
                continue;
            }
            // 家里有别人
            if (nums[i] == nums[nums[i]]) {
                repeat = nums[i];
                break;
            }

            // 回家
            nums[i] = nums[i] ^ nums[nums[i]];
            nums[nums[i]] = nums[i] ^ nums[nums[i]];
            nums[i] = nums[i] ^ nums[nums[i]];
            i--;
            // 自己回家了, 被迫回家的数字还没处理
        }

        return repeat;
    }

    public void debug() {
        int[] i = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findRepeatNumber(i));
    }

    public static void main(String[] args) {
        ShuZuZhongZhongFuDeShuZiLcof solution = new ShuZuZhongZhongFuDeShuZiLcof();
        solution.debug();
    }
}