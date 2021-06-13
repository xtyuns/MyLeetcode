package interview.jd.test1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double n = in.nextInt();
            int m = in.nextInt();
            double sum = 0;

            for (int i = 0; i < m; i++) {
                sum += n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f", sum);
        }
    }
}
