package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zinan.ji on 2020-03-27.
 */
public class RecoverTree {
    // BST 的中序遍历是升序序列
    public void recoverTree(TreeNode root) {

        List<Integer> nums = new ArrayList<>();
        // 中序遍历这棵树，保存val
        inorder(root, nums);
        // 找到需要交换的两个值
        int[] swapped = findTwoSwapped(nums);
        // 中序遍历找到两值并交换
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)){
                y = nums.get(i + 1);
                if (x == -1) x = nums.get(i);
                else break;
            }
        }
        return new int[]{x, y};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) return;
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }
}
