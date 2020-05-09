package LeetCode.owner.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinan.ji on 2020-05-10.
 */
public class Partition_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        if (s.length() == 0) return list;
        backTrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    private void backTrack(List<List<String>> list, ArrayList<String> tempList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<String>(tempList));
            return;
        }

        for (int i = start; i <= s.length() - 1; i++) {
            if (judge(s.substring(start, i + 1))) {
                tempList.add(s.substring(start, i + 1));
                //判断剩余字符串是否由多个回文构成
                backTrack(list, tempList, s, i + 1);
                //回溯
                tempList.remove(tempList.size() - 1);
            }
        }

    }

    // 双指针法
    private boolean judge(String substring) {
        int first = 0;
        int second = substring.length() - 1;
        while (first < second) {
            if (substring.charAt(first) == substring.charAt(second)) {
                first++;
                second--;
            } else return false;
        }
        return true;
    }
}

