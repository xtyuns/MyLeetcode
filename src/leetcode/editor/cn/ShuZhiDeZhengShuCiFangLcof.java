package leetcode.editor.cn;
// [剑指 Offer 16] 数值的整数次方
// 2021-06-15 08:05:19

import java.util.Arrays;

public class ShuZhiDeZhengShuCiFangLcof {
    // copy method to here
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1 || x == 1) return x;
        if (n < 0) {
            // Integer.MAX_VALUE = 2147483647, MIN_VALUE = -2147483648，所以当 n<0 时先计算一次，使数值 + 1，防止转换为正数时出现溢出
            return 1 / (x * myPow(x, -1 * (n + 1)));
        } else {
            return myPow(x, n % 2) * myPow(x * x, n >> 1);
        }
    }
    
    
    public void debug() {
        System.out.println(myPow(2, -2147483648));
    }

    public static void main(String[] args) {
        ShuZhiDeZhengShuCiFangLcof solution = new ShuZhiDeZhengShuCiFangLcof();
        solution.debug();
    }
}