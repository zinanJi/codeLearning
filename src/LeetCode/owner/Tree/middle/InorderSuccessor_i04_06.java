package LeetCode.owner.Tree.middle;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-08.
 * 面试题 04.06. 后继者
 */
public class InorderSuccessor_i04_06 {
    boolean flag = false;
    TreeNode res;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root,p);
    }

    private TreeNode helper(TreeNode root, TreeNode p) {
        if (root==null) return res;
        helper(root.left,p);
        if(root.val==p.val) {
            flag = true;  
        }else if (flag){
            res = root;
            flag = false;
        }
        helper(root.right,p);
        return res;
    }
}

