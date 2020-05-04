package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-05.
 * 572. 另一个树的子树
 */
public class IsSubtree_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 从上向下遍历 s 树的各个叶子节点
        // 如果 s 的叶子节点值跟 t 树根节点值一样，即可进入判断同一棵树程序
        // 使用 isSame 判断是否是同一棵树
        if (s == null) return false;
        if (isSame(s, t)) return true;
        else return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;
        if (q.val != p.val) return false;
        else return isSame(q.left, p.left) && isSame(q.right, p.right);

    }
}
