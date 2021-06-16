package leetcode.editor.cn;
// [剑指 Offer 20] 表示数值的字符串
// 2021-06-16 16:13:15

public class BiaoShiShuZhiDeZiFuChuanLcof {
    // copy method to here
    public boolean isNumber(String s) {
        if (null == s) return false;
        s = s.trim();
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return false;
        }

        char last = s.charAt(s.length() - 1);
        return last >= '0' && last <= '9' || last == '.';
    }
    
    public void debug() {
        System.out.println(isNumber("84656e656D"));
    }

    public static void main(String[] args) {
        BiaoShiShuZhiDeZiFuChuanLcof solution = new BiaoShiShuZhiDeZiFuChuanLcof();
        solution.debug();
    }
}