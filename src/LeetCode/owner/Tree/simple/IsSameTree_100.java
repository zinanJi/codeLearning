package LeetCode.owner.Tree.simple;

import LeetCode.TreeNode;

/**
 * Created by zinan.ji on 2020-03-27.
 * 100. 相同的树
 */
public class IsSameTree_100 {
    // 先序遍历递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 访问根结点
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        // 访问子结点
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

}
