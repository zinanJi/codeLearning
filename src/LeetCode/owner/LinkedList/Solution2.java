package LeetCode.owner.LinkedList;


import java.util.Stack;

/**
 * Created by zinan.ji on 2020-04-23.
 */
public class Solution2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode topK(TreeNode root,int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (k-- == 0) return node;
            node = node.right;
        }
        return null;
    }
}
