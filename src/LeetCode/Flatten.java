package LeetCode;

/**
 * Created by zinan.ji on 2020-03-27.
 * 114. 二叉树展开为链表
 */
public class Flatten {
    public void flatten(TreeNode root) {
        change(root);
    }

    private void change(TreeNode root) {
        if (root==null) return;
        if (root.right!=null) change(root.right);

    }
}
