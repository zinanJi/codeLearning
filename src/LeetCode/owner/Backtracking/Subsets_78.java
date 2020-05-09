package LeetCode.owner.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zinan.ji on 2020-05-09.
 */
public class Subsets_78 {
    
    // 解决一个回溯问题，实际上就是一个决策树的遍历过程
    // 考虑三个问题：路径，选择列表，结束条件
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backTrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        // 这里可以用if增加结束条件
        // tempList是选择的路径，把满足结束条件的路径添加到结果中
        list.add(new ArrayList<>(tempList));
        // 回溯算法的核心
        // for 选择 in 选择列表:
        //     做选择
        //     将该选择从选择列表移除
        //     路径.add(选择)
        //     backtrack(路径, 选择列表)
        //     撤销选择
        //     路径.remove(选择)
        //     将该选择再加入选择列表
        for (int i = start; i < nums.length; i++) {
            // 在递归之前做选择
            tempList.add(nums[i]);
            // 调用递归传入路径tempList和选择路径nums，i+1
            backTrack(list, tempList, nums, i + 1);
            // 在递归之后撤销选择
            tempList.remove(tempList.size() - 1);
        }
    }
}

