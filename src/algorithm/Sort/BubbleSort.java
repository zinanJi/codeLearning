package algorithm.Sort;

public  class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) return null;


        // 从0到array.length
        for(int i = 0; i < array.length; i++) {
            // 每一遍有一个末尾的数排好序，所以从0到排序到已排序i个数
            for (int j = 0;j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
