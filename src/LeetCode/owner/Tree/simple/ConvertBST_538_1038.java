package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-04-29.
 * 538. 把二叉搜索树转换为累加树
 * 1038. 从二叉搜索树到更大和树
 */
public class ConvertBST_538_1038 {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // 先访问右结点，再访问根结点，再访问左结点的顺序
        if (root==null) return null;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return ;
        helper(root.right);
        root.val += sum;
        sum = root.val;
        helper(root.left);
    }
}