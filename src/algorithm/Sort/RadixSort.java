package algorithm.Sort;

import java.util.ArrayList;

public class RadixSort {
    /* 非比较算法，对每一位进行排序，从最低位开始排序，也可用于优先级排序*/
    /*
        取得数组中的最大数，并取得位数；
        arr为原始数组，从最低位开始取每个位组成radix数组；
        对radix进行计数排序（利用计数排序适用于小范围数的特点）；
    */
    public int[] radixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;


        // 取最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }

        int mod = 10, div = 1;

        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) bucketList.add(new ArrayList<>());

        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < array.length; j++) {
                // 获得每一个数的第i位num
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }

            // 拉链法循环访问数据
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }
}


