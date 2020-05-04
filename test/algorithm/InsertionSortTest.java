package algorithm;

import algorithm.Sort.InsertionSort;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {



    @Test
    public void insertionSort() throws Exception {

        int[] array = {7,5,1,9,3,6,4};

        InsertionSort insertion_sort = new InsertionSort();

        int[] a = insertion_sort.insertionSort(array);

        // 验证是否有7条数据返回
        assertEquals(7, a.length);

        // 验证数据是否为顺序输出
        assertArrayEquals(new int[]{1, 3, 4, 5, 6, 7, 9}, a);

    }

}