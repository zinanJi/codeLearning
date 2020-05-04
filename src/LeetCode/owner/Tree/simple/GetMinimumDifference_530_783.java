package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-04-29.
 * 530. 二叉搜索树的最小绝对差
 * 783. 二叉搜索树节点最小距离
 */
public class GetMinimumDifference_530_783 {
    // 二叉搜索树中序遍历就是一个升序序列，求相邻两个数（当前数和上一个数）之间最小差
    private int num = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        inOrder(root);
        return num;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null)
            num = Math.min(num, root.val - pre.val);
        pre = root;
        inOrder(root.right);

    }
}
