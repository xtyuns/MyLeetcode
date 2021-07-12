package leetcode.editor.cn;
// [剑指 Offer 44] 数字序列中某一位的数字
// 2021-07-12 09:12:22

import java.nio.charset.StandardCharsets;

public class ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    // copy method to here
    public int findNthDigit(int n) {
        int ans = n;

        int digit = 1;
        long start = 1;
        long count = 9;

        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;
        }

        int num = (int) (start + (n - 1) / digit);


        return String.valueOf(num).charAt(--n % digit) - '0';
    }

    public void debug() {
        System.out.println(findNthDigit(11));
    }

    public static void main(String[] args) {
        ShuZiXuLieZhongMouYiWeiDeShuZiLcof solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcof();
        solution.debug();
    }
}