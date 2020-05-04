package algorithm.Sort;

import java.util.ArrayList;

public class QuickSort {
    public int[] quickSort(int[] array, int start, int end) {
        if (array == null || array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        // 快排一遍后得到一个已经正确的序号
        int smallIndex = partition(array, start, end);
        // 该序号大于起点，处理起点->序号，即左侧数组
        if (smallIndex > start) {
            quickSort(array, start, smallIndex - 1);
        }
        // 该序号小于终点，处理序号-终点，即右侧数组
        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    private int partition(int[] array, int start, int end) {
        // 快速排序法有三种算法实现：左右指针法，挖坑法和前后指针法。左右指针法和挖坑法只能针对顺序序列进行排序，
        // 如果是对一个链表进行排序， 就无用武之地了。
        // 这里采取前后指针法：
        // 定义变量i指向序列的开头，定义变量smallIndex指向i的前一个位置。取基准数与最后一个数交换
        // 当array[i] < array[end]时，i和smallIndex同时往后走，如果array[i]> array[end]，i往后走，smallIndex留在大于array[end]的数值前一个位置。
        // 当array[cur]再次 < key时，交换array[cur]和array[pre]。
        // 基准随机选取
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[] quickSort2(int[] array, int start, int end) {
        // 左右指针法
        if (array == null || array.length < 1 || start < 0 || end >= array.length || start > end) return null;

        int pivot = partition2(array,start,end);

        quickSort2(array, start, pivot - 1);
        quickSort2(array, pivot + 1, end);
        return array;
    }

    private static int partition2(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int temp = array[i];
        while (i != j) {
            while (array[j] >= temp && i < j)
                j--;
            while (array[i] <= temp && i < j)
                i++;
            if (i < j) swap(array, i, j);
        }
        array[start] = array[i];
        array[i] = temp;
        return i;
    }

}
