package leetcode.editor.cn;
// [剑指 Offer 09] 用两个栈实现队列
// 2022-01-06 18:25:07

import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof {
    String id = "剑指 Offer 09";

    public static void main(String[] args) {
        CQueue solution = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CQueue {
        private final Stack<Integer> inStack;
        private final Stack<Integer> outStack;

        public CQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        public void appendTail(int value) {
            // 只有一个元素, 直接放入 outStack(队列出口)
            if (this.outStack.empty() && this.inStack.empty()) {
                this.outStack.push(value);
            } else {
                // 否则先放入 inStack, 需要出队时再反转栈顺序
                this.inStack.push(value);
            }
        }

        public int deleteHead() {
            // 队列出口可以直接取值, 直接出队即可
            if (!this.outStack.empty()) {
                return this.outStack.pop();
            }
            // 双栈都没有元素, 此时队列为空, 返回题目规定的值
            if (this.inStack.empty()) {
                return -1;
            }
            // 反转栈顺序, 然后出队
            while (!this.inStack.empty()) {
                this.outStack.push(this.inStack.pop());
            }
            return this.outStack.pop();
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}