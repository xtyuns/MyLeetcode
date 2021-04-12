package newcoder.practice.niu_niu_zhao_gong_zuo;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

// 牛牛找工作: https://www.nowcoder.com/practice/46e837a4ea9144f5ad2021658cb54c4d
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int[][] works = new int[N][2];
        TreeMap<Integer, Integer> workMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            works[i][0] = in.nextInt();
            works[i][1] = in.nextInt();
        }
        // 将工作按照难度进行排序
        Arrays.sort(works, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        for (int i = 0; i < works.length; i++) {
            if (i > 0) {
                // 可能存在高难度低报酬的工作, 此时选择相对高薪的工作
                works[i][1] = Math.max(works[i - 1][1], works[i][1]);
            }
            workMap.put(works[i][0], works[i][1]);
        }

        for (int i = 0; i < M; i++) {
            int d = in.nextInt();
            Integer index = workMap.floorKey(d);
            if (index == null) {
                System.out.println(0);
            } else {
                System.out.println(workMap.get(index));
            }
        }
    }
}
