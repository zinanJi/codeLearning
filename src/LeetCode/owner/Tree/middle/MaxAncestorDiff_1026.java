package LeetCode.owner.Tree.middle;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-09.
 * 1026. 节点与其祖先之间的最大差值
 * 
 */
public class MaxAncestorDiff_1026 {

    int sum = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val, root.val);
        return sum;
    }

    // 因为要存储路径上面的最大值和最小值，所以要把值往下传到叶子结点处使用
    private void helper(TreeNode root, int max, int min) {
        if (root == null) return;
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        if (root.left == null && root.right == null)
            sum = Math.max(sum, Math.abs(max - min));
        helper(root.left, max, min);
        helper(root.right, max, min);
    }
}
