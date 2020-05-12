package LeetCode.owner.Tree.middle;

import LeetCode.owner.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinan.ji on 2020-03-25.
 * 95. 不同的二叉搜索树 II
 */
public class GenerateTrees_95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) return ans;
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();


        if (start > end) {
            ans.add(null);
            return ans;
        }
        
        for (int i = start; i <= end; i++) {
            // 递归得到i的所有可能的左子树集合
            List<TreeNode> leftTree = generate(start, i - 1);
            // 递归得到i的所有可能的右子树集合
            List<TreeNode> rightTree = generate(i + 1, end);
            // 左子树和右子树结合把根节点加入到ans返回给上一层
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
