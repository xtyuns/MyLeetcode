package newcoder.practice.biao_da_shi_qiu_zhi;

import java.util.Scanner;

// 表达式求值: https://www.nowcoder.com/practice/3e483fe3c0bb447bb17ffb3eeeca78ba
// 可以用 dp 优化
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int ans = Integer.MIN_VALUE;
        ans = Math.max(a + b + c, ans);
        ans = Math.max(a * b * c, ans);
        ans = Math.max(a + b * c, ans);
        ans = Math.max(a * b + c, ans);
        ans = Math.max((a + b) * c, ans);
        ans = Math.max(a * (b + c), ans);
        System.out.println(ans);
    }
}
