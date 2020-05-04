package LeetCode.owner.Tree.base;

import LeetCode.owner.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class PreorderTraversal_144 {
    public List<Integer> preorderTraversalRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOder(root,res);
        return res;

    }

    private void preOder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        res.add(root.val);
        preOder(root.left,res);
        preOder(root.right,res);
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return res;
    }
}
