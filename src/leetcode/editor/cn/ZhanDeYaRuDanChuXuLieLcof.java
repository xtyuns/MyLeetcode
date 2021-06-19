package leetcode.editor.cn;
// [剑指 Offer 31] 栈的压入、弹出序列
// 2021-06-18 15:50:45

import java.util.Stack;

public class ZhanDeYaRuDanChuXuLieLcof {
    // copy method to here
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int cursor = 0, popLength = popped.length;

        for (int i : pushed) {
            stack.push(i);
            while (!stack.empty() && cursor < popLength && popped[cursor] == stack.peek()) {
                stack.pop();
                cursor++;
            }
        }

        return cursor == popLength;
    }

    public void debug() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(a, b));
    }

    public static void main(String[] args) {
        ZhanDeYaRuDanChuXuLieLcof solution = new ZhanDeYaRuDanChuXuLieLcof();
        solution.debug();
    }
}