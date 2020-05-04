package algorithm.Sort;

import java.util.Arrays;

public class CountingSort {
    public int[] countingSort(int[] array) {
        if (array == null || array.length == 0) return null;
        int bias;
        // 找最大值+最小值
        int max = array[0], min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        // 定义偏差值
        bias = 0 - min;
        // 声明计数数组
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        // 计数
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        // 根据计数设置输出数组
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return array;
    }


}
