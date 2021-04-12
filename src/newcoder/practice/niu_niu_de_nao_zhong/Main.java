package newcoder.practice.niu_niu_de_nao_zhong;

import java.util.Arrays;
import java.util.Scanner;

// 牛牛的闹钟: https://www.nowcoder.com/practice/9173e83d1774462f81255a26feafd7c6
// tip: 闹钟需要进行排序
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        int[] alarms = new int[nums];
        for (int i = 0; i < nums; i++) {
            alarms[i] = in.nextInt() * 60 + in.nextInt();
        }
        Arrays.sort(alarms);
        int target = in.nextInt();
        target = in.nextInt() * 60 + in.nextInt() - target;

        for (int i = alarms.length - 1; i >= 0; i--) {
            if (alarms[i] <= target) {
                System.out.println(alarms[i] / 60 + " " +alarms[i] % 60);
                break;
            }
        }
    }
}
