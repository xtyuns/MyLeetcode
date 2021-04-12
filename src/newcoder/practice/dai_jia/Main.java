package newcoder.practice.dai_jia;

import java.util.Arrays;
import java.util.Scanner;

// 代价: https://www.nowcoder.com/practice/b7985769dc434d85a16717908669bcab
// 排序相减即为最小代价, 算式展开后就是最大值减去最小值
public class Main {
    public static void main(String[] args) {
        int N = 3;
        Scanner in = new Scanner(System.in);
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = in.nextInt();
        }
        Arrays.sort(list);
        System.out.println(list[N-1] - list[0]);
    }
}
