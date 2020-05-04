package algorithm.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zinan.ji on 2020-04-29.
 * frameCode以78. 子集为例
 * 回溯算法就是对隐式图的深度优先搜索算法，即多叉树的前后序遍历问题
 * 写 backtrack 函数时，需要维护走过的「路径」和当前可以做的「选择列表」，当触发「结束条件」时，将「路径」记入结果集。
 */
public class frameCode {
    // 输入条件是一个数组，也可能是字符串
    public List<List<Integer>> subsets(int[] nums) {
        // 一个全局变量集合保存所有满足条件的答案
        List<List<Integer>> list = new ArrayList<>();
        // 有些题目不需要排序
        Arrays.sort(nums);
        // 传入四个参数
        // 第二个参数是一个集合，保存一个满足条件的答案，举例：List<Integer> tempList
        backTrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backTrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int start) {
        // 这里可以设置终结条件，也是满足条件的时候，全局变量添加一个满足条件的集合
        list.add(new ArrayList<>(tempList));
        for (int i = start;i<nums.length;i++){
            tempList.add(nums[i]);
            // 递归调用，进入下一层决策树，此时的tempList一直在变化，直到满足终结条件才结束
            backTrack(list,tempList,nums,i+1);
            // 移除tempList最后一个元素，作用就是返回上一次调用时的数据，也就是希望返回之前的节点再去重新搜索满足条件。这样才能实现回溯
            tempList.remove(tempList.size()-1);
        }
    }
}
