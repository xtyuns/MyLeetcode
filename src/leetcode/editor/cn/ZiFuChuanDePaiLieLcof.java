package leetcode.editor.cn;
// [剑指 Offer 38] 字符串的排列
// 2021-06-25 21:41:21

import java.util.*;

public class ZiFuChuanDePaiLieLcof {
    // copy method to here
    List<String> list = new ArrayList<>();
    char[] cs = null;
    int len = 0;
    public String[] permutation(String s) {
        cs = s.toCharArray();
        len = cs.length;
        // 0 表示已经确定了全排列中的前 0 个元素, 即: 在搜索树上已经遍历了 0 层
        backtrace(0);
        return list.toArray(new String[0]);
    }

    private void backtrace(int i) {
        if (len - i <= 1) {
            list.add(new String(cs));
            return;
        }

        // 去重: "aab", 例如: 当确定全排列的第一个元素时, 如果循环到第二个 a, 那么它必定和第一个 a 与其他元素的交换做第一个元素的情况完全重复, 因此进行剪枝
        Set<Character> set = new HashSet<>();
        for (int j = i; j < len; j++) {
            if (set.contains(cs[j])) continue;
            set.add(cs[j]);

            // 使用回溯法实现全排列
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;

            backtrace(i + 1);

            cs[j] = cs[i];
            cs[i] = tmp;
        }
    }

    public void debug() {
        System.out.println(Arrays.toString(permutation("aab")));
    }

    public static void main(String[] args) {
        ZiFuChuanDePaiLieLcof solution = new ZiFuChuanDePaiLieLcof();
        solution.debug();
    }
}