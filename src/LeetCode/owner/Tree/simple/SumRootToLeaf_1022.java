package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-04-29.
 * 1022. 从根到叶的二进制数之和
 */
public class SumRootToLeaf_1022 {

    int result = 0;

    // 前序遍历，边遍历边加 二进制数，先把sum左移一位，再加上当前值。如果到了叶子结点，就把sum累加到result上，否则将当前sum传入下一个结点
    public int sumRootToLeaf(TreeNode root) {
        if (root==null) return 0;
        preOrder(root,0);
        return result;
    }

    private void preOrder(TreeNode root, int sum) {
        if (root==null)return;
        sum = sum<<1;
        sum += root.val;
        if (root.left==null&&root.right==null)
            result += sum;
        preOrder(root.left,sum);
        preOrder(root.right,sum);
    }
}
