package algorithm.Sort;

import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) return null;
        // 设置终止条件，否则会java.lang.StackOverflowError
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    // 将两段排好序的数组结合成一个数组
    // 如1379和2456
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        // 需要三个变量表示result、left、right的下标
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            // 如果i超过left的长度，说明left的值已经全都填充到result中
            if (i >= left.length) {
                result[index] = right[j++];
            }
            // 如果j超过right的长度，说明right的值已经全都填充到result中
            else if (j >= right.length) {
                result[index] = left[i++];
            }
            // 对比两个数组的值并填充至result中
            else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else
                result[index] = left[i++];
        }
        return result;
    }
}
