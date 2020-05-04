package algorithm;

import algorithm.Sort.BucketSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BucketSortTest {
    @Test
    public void bucketSort() throws Exception {
        int[] array = {7, 5, 1, 9, 3, 6, 4};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        BucketSort bucketSort = new BucketSort();

        ArrayList<Integer> a = bucketSort.bucketSort(list, 2);

        // 验证是否有7条数据返回
        assertEquals(7, a.size());

        int[] sorted = {1, 3, 4, 5, 6, 7, 9};
        Integer[] integers = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            integers[i] = sorted[i];
        }
        List<Integer> lists = Arrays.asList(integers);

        // 验证数据是否为顺序输出
        for (int i = 0; i < a.size(); i++) {
            assertTrue(a.get(i).equals(lists.get(i)));
        }

    }

}