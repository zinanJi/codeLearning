package algorithm.Sort;

public class HeapSort {

    // 声明全局变量，用于记录array的长度
    static int len;

    public int[] heapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        buildMaxHeap(array);
        // 循环将堆首位与末位交换，然后再调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }

        return array;
    }

    // 构建最大堆
    private void buildMaxHeap(int[] array) {
        // 从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len - 1) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    // 调整堆
    private void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        // 如果有左子树(i*2)，且左子树大于父节点，则最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        // 如果有右子树(i*2+1)，且右子树大于父节点，则最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        if (maxIndex != i) {
            swap(array, i, maxIndex);
            adjustHeap(array, maxIndex);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
