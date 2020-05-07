package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zinan.ji on 2020-05-08.
 * 107. 二叉树的层次遍历 II
 */
public class LevelOrderBottom_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<List<Integer>>();
        LinkedList<List<Integer>> result = new LinkedList<>();
        postOrder(root, 1, result);
        return result;
    }


    private void postOrder(TreeNode root, int index, LinkedList<List<Integer>> result) {
        if (root == null) return;
        if (result.size() < index) result.addFirst(new LinkedList<Integer>());
        // 层次遍历自底向上，则用size-层级得到层级转置，0对应最后一层。
        result.get(result.size() - index).add(root.val);
        if (root.left != null) postOrder(root.left, index + 1, result);
        if (root.right != null) postOrder(root.right, index + 1, result);

    }
}
