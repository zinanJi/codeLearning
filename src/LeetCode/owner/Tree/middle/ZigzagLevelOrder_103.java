package LeetCode.owner.Tree.middle;

import LeetCode.owner.Tree.TreeNode;

import java.util.*;

/**
 * Created by zinan.ji on 2020-03-26.
 * 103. 二叉树的锯齿形层次遍历
 */
public class ZigzagLevelOrder_103 {
    // 层次遍历的变种
    private int depth = 0;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        LinkedList<Integer> level_list = new LinkedList<Integer>();
        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node;
                if ((depth + 1) % 2 == 0) {
                    node = deque.pollFirst();
                    if (node.left != null)
                        deque.addLast(node.right);
                    if (node.right != null)
                        deque.addLast(node.left);
                    level_list.add(node.val);
                } else {
                    node = deque.pollLast();
                    if (node.left != null)
                        deque.addFirst(node.left);
                    if (node.right != null)
                        deque.addFirst(node.right);
                    level_list.add(node.val);
                }
            }
            results.add(level_list);
            level_list = new LinkedList<Integer>();
            depth++;
        }


        return results;
    }
}
