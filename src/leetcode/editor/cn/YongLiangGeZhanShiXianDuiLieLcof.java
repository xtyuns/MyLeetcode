package leetcode.editor.cn;
// [剑指 Offer 09] 用两个栈实现队列
// 2021-06-13 08:32:00

import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof {
    // copy method to here
    Stack<Integer> stack = null;
    Stack<Integer> queue = null;
    public YongLiangGeZhanShiXianDuiLieLcof() {
        this.stack = new Stack<>();
        this.queue = new Stack<>();
    }

    public void appendTail(int value) {
        this.stack.push(value);
    }

    public int deleteHead() {
        if (!this.queue.empty()) {
            return this.queue.pop();
        } else if (this.stack.empty()) {
            return -1;
        } else {
            while (!this.stack.empty()) {
                this.queue.push(this.stack.pop());
            }
            return deleteHead();
        }
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        YongLiangGeZhanShiXianDuiLieLcof solution = new YongLiangGeZhanShiXianDuiLieLcof();
        solution.debug();
    }
}