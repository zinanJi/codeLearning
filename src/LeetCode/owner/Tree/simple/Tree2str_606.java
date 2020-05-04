package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-05.
 * 606. 根据二叉树创建字符串
 */
public class Tree2str_606 {
    // 前序遍历，加括号时区分左右子树
    // 如果当前节点没有孩子，那我们不需要在节点后面加上任何括号；
    // 如果当前节点有两个孩子，那我们在递归时，需要在两个孩子的结果外都加上一层括号；
    // 如果当前节点只有左孩子，那我们在递归时，只需要在左孩子的结果外加上一层括号，而不需要给右孩子加上任何括号；
    // 如果当前节点只有右孩子，那我们在递归时，需要先加上一层空的括号 () 表示左孩子为空，再对右孩子进行递归，并在结果外加上一层括号。
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return t.val + "";
        if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}
