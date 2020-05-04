package solution;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    // 将问题的解决方法从找到和为固定数的两个数转换为，固定一个数找另一个数
    // target - 当前值 为键， 索引为值，有点绕，也可以倒过来map.containsValue()
    public int[] twoSums(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                return new int[]{map.get(input[i]),i};
            }
            map.put(target - input[i], i);
        }
        return null;
    }
}
