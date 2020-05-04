package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        // 初始化
        initialNode(root);

        // 层次遍历，走每一层最后一个节点指向null
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int height = queue.size();
            for (int i = 0; i < height; i++) {
                Node node = queue.poll();
                if (i < height - 1) node.next = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return root;
    }

    private void initialNode(Node root) {
        if (root == null || root.val == 0) return;
        if (root.left != null) initialNode(root.left);
        root.next = null;
        if (root.right != null) initialNode(root.right);
    }
}

