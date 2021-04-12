package newcoder.practice.an_zhi_lu_deng;

import java.util.Scanner;

// 安装路灯: https://www.nowcoder.com/practice/3a3577b9d3294fb7845b96a9cd2e099c
// 贪心算法
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int len = in.nextInt();
            String str = in.next();
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) == '.') {
                    j += 2;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
