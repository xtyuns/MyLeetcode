package newcoder.practice.mi_lu_de_niu_niu;

import java.util.Scanner;

// 迷路的牛牛: https://www.nowcoder.com/practice/fc72d3493d7e4be883e931d507352a4a
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += str.charAt(i) == 'L' ? -1 : 1;
        }

         ans = (ans % 4 + 4) % 4;
         String directions = "NESW";
         System.out.println(directions.charAt(ans));
    }
}
