package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-05.
 * 563. 二叉树的坡度
 */
public class FindTilt_563 {
    int result = 0;
    public int findTilt(TreeNode root) {
        if (root==null) return 0;
        postOrder(root);
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root==null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        result +=  Math.abs(left-right);
        // 向上传递的是节点和它的子节点的和
        return left+right+root.val;
    }
    
}

