package LeetCode.Tree;

import LeetCode.TreeNode;

/**
 * Created by zinan.ji on 2020-04-12.
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = dfs(root,false);
        return sum;
    }

    private int dfs(TreeNode node,boolean flag) {
        if (node == null) return 0;
        int val = 0;
        if (flag&&node.left==null&&node.right==null) {
            val = node.val;
        }

        int left = dfs(node.left,true);
        int right = dfs(node.right,false);
        return left+right+val;
    }
}
