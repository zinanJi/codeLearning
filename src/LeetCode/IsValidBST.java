package LeetCode;

/**
 * Created by zinan.ji on 2020-03-26.
 * 98. 验证二叉搜索树
 */
public class IsValidBST {
    // 二叉搜索树的性质是，
    // 节点的左子树只包含小于当前节点的数。
    // 节点的右子树只包含大于当前节点的数。
    // 所有左子树和右子树自身必须也是二叉搜索树。
    // 需要在遍历树的同时保留结点的上界与下界，在比较时不仅比较子结点的值，也要与上下界比较。
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        return isValid(root,null,null);
    }


    public boolean isValid(TreeNode node,Integer lower, Integer upper) {
        if (node==null) return true;

        int val = node.val;
        if (lower!=null && val<=lower) return false;
        if (upper!=null && val>=upper) return false;

        if (!isValid(node.left,lower,val))return false;
        if (!isValid(node.right,val,upper)) return false;

        return true;
    }

}
