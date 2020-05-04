package LeetCode;

import java.util.Stack;
/**
 * Created by zinan.ji on 2020-03-26.
 * 101. 对称二叉树
 */
public class SymmetricTree {

    // 可以运用递归和迭代两种方法解决这个问题
    // 递归版
    public boolean isSymmetricRecur(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    // 迭代版
    // 用栈实现
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode left;
        TreeNode right;
        Stack<TreeNode> stack = new Stack<>();

        if (root.left != null) {
            if (root.right == null) return false;
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null)
            return false;

        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            if (right.val != left.val) {
                return false;
            }
            if (left.left != null) {
                if (right.right == null) return false;
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null)
                return false;

            if (left.right != null) {
                if (right.left == null) return false;
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null)
                return false;
        }
        return true;
    }
}

