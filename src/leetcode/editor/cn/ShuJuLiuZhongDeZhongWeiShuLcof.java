package leetcode.editor.cn;
// [剑指 Offer 41] 数据流中的中位数
// 2021-07-02 10:28:47

import java.util.*;

public class ShuJuLiuZhongDeZhongWeiShuLcof {
    // copy method to here
    /** initialize your data structure here. */
    Queue<Integer> low, high;
    public ShuJuLiuZhongDeZhongWeiShuLcof() {
        low = new PriorityQueue<>();
        high = new PriorityQueue<>((e1, e2) -> e2 - e1);
    }

    public void addNum(int num) {
        // 对顶双堆: 大顶堆中保存较小的一部分数字, 小顶堆中保存较大的一部分数字, 这样中位数就位于两个堆的堆顶
        // 我们这里规定大顶堆中元素大于等于小顶堆(长度差距不超过1, 因为均分的第一次分给大顶堆, 那么下一次分给小顶堆, 依次循环)
        if (low.size() == high.size()) {
            low.add(num);
            high.add(low.poll());
        } else {
            high.add(num);
            low.add(high.poll());
        }
    }

    public double findMedian() {
        // 如果两个堆中的长度相等的话, 那么中位数就是两个堆顶的平均数
        // 否则中位数必定在大顶堆中, 因为我们上面规定了大顶堆为初始容器, 即 high.size() >= low.size 且 offset <= 1
        if (low.size() == high.size()) return (low.element() + high.element()) / 2.0;
        else return high.element();
    }
    
    public void debug() {

    }

    public static void main(String[] args) {
        ShuJuLiuZhongDeZhongWeiShuLcof solution = new ShuJuLiuZhongDeZhongWeiShuLcof();
        solution.debug();
    }
}