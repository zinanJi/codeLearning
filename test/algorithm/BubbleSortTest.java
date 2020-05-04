package algorithm;

import algorithm.Sort.BubbleSort;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void bubbleSort() throws Exception {
        int[] array = {7,5,1,9,3,6,4};

        BubbleSort.bubbleSort(array);
        for (int i = 0; i< array.length ; i++) {
            System.out.print(array[i]);
        }
    }


}