package algorithm.Sort;

public class SelectionSort {
    public static int[] selectionSort(int[] array) {
        if (array == null || array.length == 0) return null;

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
