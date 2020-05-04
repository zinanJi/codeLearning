package LeetCode.owner.Tree.base;

import LeetCode.owner.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class InorderTraversal_94 {
    public List<Integer> inorderTraversalRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;

    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root==null) return;

        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;

    }

}
