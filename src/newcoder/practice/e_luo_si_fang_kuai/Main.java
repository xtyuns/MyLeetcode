package newcoder.practice.e_luo_si_fang_kuai;

import java.util.Arrays;
import java.util.Scanner;

// 俄罗斯方块: https://www.nowcoder.com/practice/9407e24a70b04fedba4ab3bd3ae29704
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] gird = new int[n];
        for (int i = 0; i < m; i++) {
            int down = in.nextInt();
            gird[--down]++;
        }
        Arrays.sort(gird);
        System.out.println(gird[0]);
    }
}
