package LeetCode.owner.Tree.middle;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-08.
 * 面试题 04.05. 合法二叉搜索树
 */
public class IsValidBST_i04_05 {
    long pre;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        pre = Long.MIN_VALUE;
        flag = true;
        inOrder(root);
        return flag;
    }

    private void inOrder(TreeNode root) {
        if (root == null || !flag) return;
        inOrder(root.left);
        if (root.val > pre) {
            pre = root.val;
        } else {
            flag = false;
        }
        inOrder(root.right);
    }
}
