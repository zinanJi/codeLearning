package algorithm.Sort;

import java.util.ArrayList;

public class BucketSort {
    // 映射函数入桶
    public ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找最大值，最小值
        for (int i = 1; i < array.size(); i++) {
            if (max < array.get(i))
                max = array.get(i);
            if (min > array.get(i))
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        // 拉链法
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        // 声明计数数组
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            // 当桶数量为1时要手动减小BucketSize增加下一循环桶的数量，否则会陷入死循环，导致内存溢出。
            if (bucketCount == 1) bucketSize--;
            ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
            resultArr.addAll(temp);
        }

        return resultArr;
    }

}
