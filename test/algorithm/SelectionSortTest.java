package algorithm;

import algorithm.Sort.SelectionSort;
import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void selectionSort() throws Exception {
        int[] array = {7,5,1,9,3,6,4};

        SelectionSort.selectionSort(array);
        for (int i = 0; i< array.length ; i++) {
            System.out.print(array[i]);
        }
    }

}