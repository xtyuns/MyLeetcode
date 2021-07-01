package leetcode.editor.cn;
// [剑指 Offer 40] 最小的k个数
// 2021-07-01 10:01:06

import java.util.Arrays;

public class ZuiXiaoDeKgeShuLcof {
    // copy method to here
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0 || arr.length < k) return new int[0];
        return quick_topk(arr, k, 0, arr.length - 1);
    }

    private int[] quick_topk(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            // 选择最左侧 arr[l] 作为中点, 先找到右侧小于或等于参考点的位置, 再找到左侧大于参考点的位置, 最终将他们进行交换
            while (i < j && arr[j] > arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        // 循环结束后 i==j, 然后将参考点归位到中点位置, 此时 i 左侧都是小于 arr[i] 的值、i 右侧都是大于 arr[i] 的值
        swap(arr, l, i);

        // 如果 i==k, 则直接返回即可, 因为无需保证有序, 否则调整 arr 数组至 i==k
        if (i < k) quick_topk(arr, k, i + 1, r);
        if (i > k) quick_topk(arr, k, l, i - 1);

        return Arrays.copyOfRange(arr, 0, k);
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public void debug() {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3, 2, 1}, 2)));
    }

    public static void main(String[] args) {
        ZuiXiaoDeKgeShuLcof solution = new ZuiXiaoDeKgeShuLcof();
        solution.debug();
    }
}