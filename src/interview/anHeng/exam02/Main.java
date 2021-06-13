package heng.exam02;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strs = in.nextLine();

        Map<Byte, Integer> map = new HashMap<>();
        int bt = 0;
        int max = 0;
        for (byte aByte : strs.getBytes(StandardCharsets.UTF_8)) {
            int count = map.getOrDefault(aByte, 0) + 1;
            map.put(aByte, count);
            if (count > max) {
                bt = aByte;
                max = count;
            }
        }
        System.out.println((char) bt);
    }
}
