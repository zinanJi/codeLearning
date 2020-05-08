package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-08.
 * 111. 二叉树的最小深度
 */
public class MinDepth_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if (root.left == null && root.right == null) return 1;
        // 2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度    
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //这里其中一个节点为空，说明left和right有一个必然为0，所以可以返回left + right + 1;
        if (root.left == null || root.right == null) return left + right + 1;

        return Math.min(left, right) + 1;
    }
}
