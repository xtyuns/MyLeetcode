package leetcode.editor.cn;
// [剑指 Offer 05] 替换空格
// 2021-06-12 16:56:06

public class TiHuanKongGeLcof {
    // copy method to here
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public void debug() {
    }

    public static void main(String[] args) {
        TiHuanKongGeLcof solution = new TiHuanKongGeLcof();
        solution.debug();
    }
}