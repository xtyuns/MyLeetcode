package leetcode.editor.cn;
// [剑指 Offer 15] 二进制中1的个数
// 2021-06-14 16:12:55

public class ErJinZhiZhong1deGeShuLcof {
    // copy method to here
    public int hammingWeight(int n) {
        String bin = Integer.toBinaryString(n);
        int ans = 0;
        while (n != 0) {
            bin = Integer.toBinaryString(n);
            ans += (n & 1) == 1 ? 1 : 0;
            n = n >>> 1;
        }

        return ans;
    }
    
    public void debug() {
        System.out.println(hammingWeight(0b1111111111<<22));
    }

    public static void main(String[] args) {
        ErJinZhiZhong1deGeShuLcof solution = new ErJinZhiZhong1deGeShuLcof();
        solution.debug();
    }
}