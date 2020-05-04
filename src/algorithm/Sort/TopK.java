package algorithm.Sort;

import java.util.PriorityQueue;

/**
 * Created by zinan.ji on 2020-04-20.
 */
public class TopK {
    // 优先队列可一个构建堆
    public int findKthLargest(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int n : array) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    // 自己实现堆
    public int findKthLargest2(int[] array, int k) {
        buildHeap(array, k);
        for (int i = k; i < array.length; i++) {
            if (array[i] > array[0]) {
                array[0] = array[i];
                adjustHeap(array, 0, k);

            }
        }
        return array[0];
    }

    private void adjustHeap(int[] array, int i, int k) {
        int temp = array[i];
        int childIndex = 2 * i + 1;
        while (childIndex < k) {
            if (childIndex + 1 < k && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp <= array[childIndex]) break;
            array[i] = array[childIndex];
            i = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[i] = temp;
    }

    private void buildHeap(int[] array, int k) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (k - 2) / 2; i >= 0; i--) {
            adjustHeap(array, i, k);
        }
    }

    // 快速排序
    public int findKthLargest3(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start<end){
            int pivot = partition(array, start, end);
            if (pivot < array.length - k) start = pivot+1;
            else if (pivot > array.length - k) end = pivot-1;
            else return array[pivot];
        }
        return array[array.length - k];

    }

    private int partition(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int temp = array[i];
        while (i != j) {
            while (array[j] >= temp && i < j) j--;
            while (array[i] <= temp && i < j) i++;
            if (i < j) swap(array, i, j);
        }
        array[start] = array[i];
        array[i] = temp;
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
