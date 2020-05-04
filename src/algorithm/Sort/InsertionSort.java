package algorithm.Sort;

public class InsertionSort {
    public  int[] insertionSort(int[] array) {
        if (array == null || array.length == 0) return null;

        int current;

        // current取到i+1所以i < array.length - 1
        for (int i = 0;i < array.length - 1; i++) {
            // 选定序列的下一位为当前插入值
            current = array[i+1];

            int preIndex = i;
            while(preIndex >= 0  && current < array[preIndex]) {
                // 插入算法的核心，从后往前走，在找到current的正确位置之前所有元素都后移一位
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            // 将current插入数组中
            array[preIndex + 1] = current;
        }
        return array;

    }

}
