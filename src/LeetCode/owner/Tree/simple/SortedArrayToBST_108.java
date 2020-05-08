package LeetCode.owner.Tree.simple;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-05-08.
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST_108 {
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        // 高度平衡二叉树
        // 升序排序——中序遍历
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        int p = (left + right) / 2;

        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }
}
