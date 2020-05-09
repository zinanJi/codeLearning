package LeetCode.owner.Tree.middle;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-09.
 */
public class LowestCommonAncestor_i04_08 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后序遍历
        if (root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 找到root==p或q，若left或right中有另外一个目标结点，直接返回root，否则，也应该返回root，表示找到了其中一个目标
        if (root == p || root == q) return root;
        // 否则，若左右子树都有返回，说明左右各自包含目标结点，则root就是答案
        else if (left != null && right != null) return root;
        // 左子树含有其中一个结点，返回左子树的root
        else if (left != null) return left;
        // 右子树含有其中一个结点，返回右子树的root
        else return right;
    }
}
