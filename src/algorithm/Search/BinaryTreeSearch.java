package algorithm.Search;

public class BinaryTreeSearch {
    // 二叉树查找算法
    private static class BinaryTree {
        int data;
        BinaryTree lchild;
        BinaryTree rchild;
    }

    // 声明用于存储输入数据的二叉树
    static BinaryTree newTree = new BinaryTree();

    // 全局变量，存放查找到的关键字所在的父节点
    static BinaryTree parentNode = new BinaryTree();
    // parent指向bt的双亲，其初始调用值为null
    // 查找成功返回true，并将树节点赋值给全局变量result，查找失败返回false
    public boolean searchBinaryTree(BinaryTree bt,int key,BinaryTree parent) {
        if (bt == null || bt.data == 0) { // 树节点不存在，返回
            parentNode = parent;
            return false;
        }
        else if (key == bt.data) { // 查找成功
            parentNode = bt;
            return true;
        }
        else if (key < bt.data) { // 关键字小于根节点查找左子树
            return searchBinaryTree(bt.lchild, key, bt);
        }
        else { // 关键字大于根节点查找右子树
            return searchBinaryTree(bt.rchild, key, parent);
        }


    }

    // 将key挂上二叉树，并构建为二叉排序树
    public boolean generateBinaryTree(int key) {
        BinaryTree binaryTree;
        if (!searchBinaryTree(newTree, key,null)){
            binaryTree = new BinaryTree();
            binaryTree.data = key;
            binaryTree.lchild=binaryTree.rchild=null;
            if (null==parentNode) { // 不存在，证明是父节点，将binaryTree指向bt成为新的根节点
                newTree = binaryTree;
            }
            // 当key小于子根节点，插入为左孩子
            else if (key<parentNode.data) {
                parentNode.lchild = binaryTree;
            }
            // 当key大于子根节点，插入为右孩子
            else {
                parentNode.rchild = binaryTree;
            }
            // 前序遍历检查一下
            preOrderTraverse(newTree);
            return true;
        }
        else {
            System.out.println("该节点已存在");
        }
        return false;
    }

    // 前序遍历
    static void preOrderTraverse(BinaryTree t){
        if (null ==t||t.data==0) return;
        System.out.println("["+t.data+"]");
        if (t.lchild!=null) preOrderTraverse(t.lchild);
        if (t.rchild!=null) preOrderTraverse(t.rchild);
    }


}
