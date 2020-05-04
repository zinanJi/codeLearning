package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-04-29.
 */
public class DiameterOfBinaryTree_543 {

    private int max_diameter = 1;

    // 一条路径的长度为该路径经过的节点数减一
    // 解法类似于是否为平衡二叉树，都是取左右子树两边的值操作
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) return 0;
        postOrder(root);
        return max_diameter - 1;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        max_diameter = Math.max(max_diameter, left + right + 1);
        return Math.max(left, right) + 1;
    }
}

