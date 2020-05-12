package LeetCode.owner.Tree.middle;

import LeetCode.owner.Tree.TreeNode;

/**
 * Created by zinan.ji on 2020-03-28.
 */
public class BuildTreeByPreOrderAndInOrder_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

    private TreeNode help(int[] preorder, int pStart, int pEnd,int[] inorder,int iStart, int iEnd){
        if (pStart>pEnd || iStart>iEnd) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[pStart]);
        // index为根节点在中序遍历的位置
        int index =0;
        while (inorder[iStart+index]!=preorder[pStart]) {
            index++;
        }

        treeNode.left = help(preorder,pStart+1,pStart+index,inorder,iStart,iStart+index-1);
        treeNode.right = help(preorder,pStart+index+1,pEnd,inorder,iStart+index+1,iEnd);
        return treeNode;
    }
}
