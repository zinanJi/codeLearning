package LeetCode.owner.String;

import java.util.HashSet;

/**
 * Created by zinan.ji on 2020-04-16.
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWord_58 {
    // 要多考虑一个末尾是一个或多个空格的情况
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        
        
        return end - start;
    }
}
