package LeetCode.HOT100.slidingWindow;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;


/*
1.
暴力算法
思路：逐个检查
2. 滑动窗口
思路：通过使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
3. 优化滑动窗口
思路：可以定义字符到索引的映射HashMap<Character,Integer>，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
*/
public class LengthOfLongestSubstring {
    public int solution1(String s) {
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    result = max(result, j - i);
                }
            }
        }
        return result;
    }

    // 判断重复，没有重复就一直怼进Set里
    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    public int solution2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        // 窗口左右侧
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int solution3(String s) {


        return 0;
    }
}