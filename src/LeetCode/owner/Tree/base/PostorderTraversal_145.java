package LeetCode.owner.Tree.base;

import LeetCode.owner.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zinan.ji on 2020-04-19.
 */
public class PostorderTraversal_145 {
    public List<Integer> postorderTraversalRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root,res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }
    // 第一 stack.peek()只是取出栈顶元素，要和stack.pop()弹出栈顶元素区分开来；
    // 第二 变量last用于保存当前栈顶所弹出的元素，判断 curr.right == last 是为了避免重复访问同一个元素而陷入死循环当中。
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right ==null||cur.right==last){
                res.add(cur.val);
                stack.pop();
                last = cur;
                cur = null;
            }else{
                cur=cur.right;
            }
        }
        return res;
    }
}