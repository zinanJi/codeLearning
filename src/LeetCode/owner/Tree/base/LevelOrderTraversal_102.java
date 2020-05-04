package LeetCode.owner.Tree.base;

        import LeetCode.TreeNode;

        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Queue;
/**
 * Created by zinan.ji on 2020-03-26.
 * 102. 二叉树层次遍历
 */
public class LevelOrderTraversal_102 {

    // 解法1：bfs，通过层次遍历记录每层数据，可以利用队列实现
    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) nextQueue.add(node.left);
                if (node.right != null) nextQueue.add(node.right);
            }
            queue = nextQueue;
            levels.add(list);
        }
        return levels;
    }


    // 解法2：DFS递归遍历，前序遍历，res.get[i]用来存储第i层的节点.也是回溯法的框架
    public List<List<Integer>> solution2(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(root, 1, res);
        return res;
    }

    private void dfs(TreeNode root, int index, List<List<Integer>> res) {
        if (res.size() < index) res.add(new ArrayList<Integer>());
        res.get(index - 1).add(root.val);
        if (root.left != null) {
            dfs(root.left, index + 1, res);
        }
        if (root.right != null) {
            dfs(root.right, index + 1, res);
        }
    }
}
