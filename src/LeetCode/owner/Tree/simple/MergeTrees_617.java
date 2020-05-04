package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-05.
 * 617. 合并二叉树
 */
public class MergeTrees_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
