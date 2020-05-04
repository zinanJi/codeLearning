package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-04-29.
 * 面试题 04.04. 检查平衡性
 */
public class IsBalanced_i04_04 {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        postOrder(root);
        return flag;
    }

    private int postOrder(TreeNode node){
        if(node == null) return 0;
        int left = 1 + postOrder(node.left);
        int right = 1 + postOrder(node.right);
        if(Math.abs(left-right)>1) flag = false;
        return Math.max(left,right);
    }
}