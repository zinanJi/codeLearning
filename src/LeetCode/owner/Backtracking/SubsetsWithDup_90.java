package LeetCode.owner.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zinan.ji on 2020-04-29.
 * 90. 子集Ⅱ
 */
public class SubsetsWithDup_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backTrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过 保证的是相同递归函数中 不会出现和前一个相同的数
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        (new SubsetsWithDup_90()).subsetsWithDup(nums);
    }

}
