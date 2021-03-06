package algorithm;

import algorithm.Sort.RadixSort;
import org.junit.Test;

import static org.junit.Assert.*;

public class RadixSortTest {
    @Test
    public void radixSort() throws Exception {
        int[] array = {7, 5, 1, 9, 3, 6, 4};

        RadixSort radixSort = new RadixSort();
        int[] a = radixSort.radixSort(array);

        // 验证是否有7条数据返回
        assertEquals(7, a.length);

        // 验证数据是否为顺序输出
        assertArrayEquals(new int[]{1, 3, 4, 5, 6, 7, 9}, a);
    }
}