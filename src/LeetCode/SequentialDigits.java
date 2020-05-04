package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinan.ji on 2020-03-28.
 * 1291. 顺次数
 */
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            int num = i;
            while (num % 10 > 0 || num / 10 != 0) {
                if (num % 10 != (num / 10 + 1)) break;
                num /= 10;
            }
            if (num == 0) result.add(i);
        }
        return result;
    }
}