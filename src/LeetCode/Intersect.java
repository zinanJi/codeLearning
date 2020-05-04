package LeetCode;

public class Intersect {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
    public Node intersect(Node quadTree1, Node quadTree2) {
        // 1.如果A是叶子节点
        if (quadTree1.isLeaf) {
            // 2.如果A的值为true则直接返回A树
            if (quadTree1.val) return quadTree1;
            // 3.A为叶子但A的值为false, 则返回B树
            else return quadTree2;
        }
        // 4.如果B是叶子节点
        if (quadTree2.isLeaf) {
            // 5.如果B的值为true则直接返回B树
            if (quadTree2.val) return quadTree2;
            // 6.B为叶子节点，但B的值为false，则返回A树
            else return quadTree1;
        }

        // 7.A和B都不为叶子节点的情况下，分别递归获取四个方向的子节点
        Node topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight,quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);

        // 8.如果四个节点同时为叶子节点。并且值为true时,则返回的节点进行合并,合并为一个值为true的叶子节点
        if (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val
                && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf)
            return new Node(true,true,null,null,null,null);

        // 9. 通过第7步获取得四个方位的节点，构造出一个新的节点树
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);

    }
}
