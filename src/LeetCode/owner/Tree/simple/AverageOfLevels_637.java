package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinan.ji on 2020-05-08.
 * 637. 二叉树的层平均值
 */
public class AverageOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        dfs(root, 0, result, count);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }

    private void dfs(TreeNode root, int level, List<Double> result, List<Integer> count) {
        if (root == null) return;
        if (level < result.size()) {
            result.set(level, result.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        } else {
            result.add(1.0 * root.val);
            count.add(1);
        }
        dfs(root.left, level + 1, result, count);
        dfs(root.right, level + 1, result, count);
    }
}
