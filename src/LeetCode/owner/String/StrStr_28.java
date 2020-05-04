package LeetCode.owner.String;

/**
 * Created by zinan.ji on 2020-04-16.
 */
public class StrStr_28 {
    // 滑动窗口
    // 移动 pn 指针，直到 pn 所指向位置的字符与 needle 字符串第一个字符相等。
    // 通过 pn，pL，curr_len 计算匹配长度。
    // 如果完全匹配（即 curr_len == L），返回匹配子串的起始坐标（即 pn - L）。
    // 如果不完全匹配，回溯。使 pn = pn - curr_len + 1， pL = 0， curr_len = 0。
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        int pn = 0;
        int pl;
        int curr_len;
        int hlen = haystack.length();
        int nlen = needle.length();
        while (pn < hlen - nlen + 1) {
            while (pn < hlen - nlen + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                pn++;
            }
            pl = 0;
            curr_len = 0;
            while (pn < hlen && pl < nlen && haystack.charAt(pn) == needle.charAt(pl)) {
                curr_len++;
                pl++;
                pn++;
            }
            if (curr_len == nlen) return pn - nlen;
            pn = pn - curr_len + 1;
        }
        return -1;
    }

    // 哈希匹配法
}