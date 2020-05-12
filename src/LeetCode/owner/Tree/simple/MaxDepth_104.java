package LeetCode.owner.Tree.simple;

import LeetCode.TreeNode;

/**
 * Created by zinan.ji on 2020-03-26.
 * 104. 二叉树的最大深度
 */
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        if (root ==null) return 0;

        int left_length = maxDepth(root.left);
        int right_length = maxDepth(root.right);
        return Math.max(left_length,right_length)+1;
    }
}
