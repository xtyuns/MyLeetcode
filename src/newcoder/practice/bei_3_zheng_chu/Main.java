package newcoder.practice.bei_3_zheng_chu;

import java.util.Scanner;

// 被3整除: https://www.nowcoder.com/practice/51dcb4eef6004f6f8f44d927463ad5e8
// tip: 参数要用 long 类型
public class Main {
    public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(System.in);
        long l = in.nextLong();
        long r = in.nextLong();
        for (long i = l; i <= r; i++) {
            long sum = (1 + i) * i / 2;  // (1+2+3+...+i)
            // 在 Java 中: (1 + i) * i / 2 != (1 + i) * (i / 2)
            count += sum % 3 == 0 ? 1 : 0;
        }
        System.out.println(count);
    }
}
