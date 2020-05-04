package LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zinan.ji on 2020-04-13.
 * 659. 分割数组为连续子序列
 */

public class IsPossible659 {
    public boolean isPossible(int[] nums) {
        // 每个数字的重复次数
        Map<Integer,Integer> count = new HashMap<>();
        // 以每个数字结尾的子链数
        Map<Integer,Integer> endCount = new HashMap<>();
        for(int num :nums) {
            count.put(num,count.get(num) +1);
        }
        return false;
    }
}
