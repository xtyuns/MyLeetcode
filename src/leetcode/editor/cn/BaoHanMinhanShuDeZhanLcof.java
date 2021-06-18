package leetcode.editor.cn;
// [剑指 Offer 30] 包含min函数的栈
// 2021-06-17 21:53:18

import java.util.Stack;

public class BaoHanMinhanShuDeZhanLcof {
    // copy method to here
    /**
     * initialize your data structure here.
     */
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public BaoHanMinhanShuDeZhanLcof() {
    }

    public void push(int x) {
        data.push(x);
        if (min.empty() || min.peek() >= x) min.push(x);
    }

    public void pop() {
        if (data.pop().equals(min.peek())) min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
    
    public void debug() {
        BaoHanMinhanShuDeZhanLcof minStack = new BaoHanMinhanShuDeZhanLcof();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    public static void main(String[] args) {
        BaoHanMinhanShuDeZhanLcof solution = new BaoHanMinhanShuDeZhanLcof();
        solution.debug();
    }
}