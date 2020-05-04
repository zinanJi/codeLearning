package LeetCode.owner.String;

import static java.lang.Math.min;

/**
 * Created by zinan.ji on 2020-04-16.
 * 14. 最长公共前缀
 */
public class LongestCommonPrefix_14 {
    // 水平扫描法
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 二分查找法
    // 找到最短字符串，然后二分这个字符串去匹配
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = min(str.length(), minLen);
        }
        int low = 1;
        int high = minLen;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
