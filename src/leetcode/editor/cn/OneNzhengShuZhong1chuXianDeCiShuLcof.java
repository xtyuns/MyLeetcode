package leetcode.editor.cn;
// [剑指 Offer 43] 1～n 整数中 1 出现的次数
// 2021-07-09 15:04:00

public class OneNzhengShuZhong1chuXianDeCiShuLcof {
    // copy method to here
    public int countDigitOne(int n) {
        int ans = 0;
        // 这里以 4 位数 1212 为例进行注释讲解, len = 4
        int len = String.valueOf(n).length();

        for (int i = 0; i < len; i++) {
            // 当 i = 1 时, 统计十位数上 1 的数量, 此时 cur 的权值为 10(此处选择 i = 1, 是为了方便讲解下面的 if 分支)
            int digit = (int) Math.pow(10, i);

            // n % digit 得出十位数后面的数字(1212 % 10 = 2)
            int low = n % digit;
            // n / digit 暂存 low 前面的所有数字(1212 / 10 = 121)
            int cur = n / digit;
            // 暂存的数字再除以 10 得到十位数前面的数字(121 / 10 = 12)
            int high = cur / 10;
            // 暂存的数字再对 10 取余得到十位数上的数字, 即 cur 的值(121 % 10 = 1)
            cur %= 10;

            // 此时 high = 12, cur = 1, low = 2 (i = 1, digit = 10^1)

            // 下面根据 cur 的值计算在 cur 的位置上出现 1 的个数
            if (cur == 0) {
                ans += high * digit;
            } else if (cur == 1) {
                // 十位数上出现 1 的所有情况: 01[0-9], 11[0-9], 21[0-9], ..., 111[0-9]、121[0-2]
                // (共 12 * 10 + 2 + 1 = 123 个 1, 即: 1-1212 中的所有数字中, 十位数上出现 1 的数量为 123 个)
                ans += high * digit + ++low;
            } else {
                ans += ++high * digit;
            }
            // 同理可推出其他的 if 分支
        }

        return ans;
    }

    public void debug() {
        System.out.println(countDigitOne(1410065408));
    }

    public static void main(String[] args) {
        OneNzhengShuZhong1chuXianDeCiShuLcof solution = new OneNzhengShuZhong1chuXianDeCiShuLcof();
        solution.debug();
    }
}