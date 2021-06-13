package heng.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String txt = in.nextLine();
        int n = Integer.parseInt(txt.split(",")[0]);
        txt = txt.split("\\[\\[")[1].split("]]")[0];  // 1,0],[1,2],[1,3
        String[] txts = txt.split("],\\[");

        int[][] cases = new int[txts.length][2];
        for (int i = 0; i < txts.length; i++) { // 1,0
            String[] split = txts[i].split(",");
            cases[i][0] = Integer.parseInt(split[0]);
            cases[i][1] = Integer.parseInt(split[1]);
        }

        List result = new ArrayList<Integer>(n);

    }
}
