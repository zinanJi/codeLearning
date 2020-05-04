package algorithm.Search;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;

public class Tree23 <Key extends Comparable<Key>,Value>{
    /*
        定义:
            如果一个内部节点拥有一个数据元素、两个子节点，则此节点为2节点。
            如果一个内部节点拥有两个数据元素、三个子节点，则此节点为3节点。
            当且仅当以下叙述中有一条成立时，T为2–3树：
                T为空。即T不包含任何节点。
                T为拥有数据元素a的2节点。若T的左孩子为L、右孩子为R，则
                    L和R是等高的非空2–3树；
                    a大于L中的所有数据元素；
                    a小于等于R中的所有数据元素。
            T为拥有数据元素a和b的3节点，其中a < b。若T的左孩子为L、中孩子为M、右孩子为R，则
                    L、M、和R是等高的非空2–3树；
                    a大于L中的所有数据元素，并且小于等于M中的所有数据元素；
                    b大于M中的所有数据元素，并且小于等于R中的所有数据元素。
     */

    // 保存key和value的键值对
    private class Data<Key extends Comparable<Key>,Value> {
        private Key key;
        private Value value;
        public Data(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
        public void displayData(){
            System.out.println("/" + key+"---"+value);
        }
    }

    // 保存树结点的类
    private class Node23<Key extends Comparable<Key>,Value> {

        private static final int N=3;
        // 该结点的父结点
        private Node23 parent;
        // 子结点，子结点有3个，分别是左子结点，中间子结点和右子结点
        private Node23[] childNodes = new Node23[N];
        // 代表结点保存的数据(为一个或者两个)
        private Data[] itemDatas = new Data[N-1];
        // 结点保存的数据个数
        private int itemNum = 0;

        public void displayNode(){
            for (int i=0;i<itemNum;i++)  {
                itemDatas[i].displayData();
            }
            System.out.println("/");
        }


        // 判断是否是叶子结点
        private boolean isLeaf(){
            return childNodes[0] == null;
        }

        // 判断结点存储数据是否满了
        private boolean isFull(){
            return itemNum == N-1;
        }

        // 返回该结点的父结点
        private Node23 getParent(){
            return this.parent;
        }

        // 将子结点连接到该结点
        private void connectChild(int index,Node23 child) {
            childNodes[index] = child;
            if (child!=null) {
                child.parent=this;
            }
        }

        // 解除该结点和某个结点之间的连接
        private Node23 disconnectChild(int index) {
            Node23 temp = childNodes[index];
            childNodes[index] = null;
            return temp;
        }

        // 获取结点左或右的键值对
        // index 0左1右
        private Data getData(int index) {
            return itemDatas[index];
        }


        // 获取某个位置的子树
        private Node23 getChild(int index){
            return childNodes[index];
        }

        // 返回该结点中键值对的数量，空则返回-1
        private int getItemNum() {
            return itemNum;
        }

        // 寻找key在结点的位置
        private int findItem(Key key) {
            for (int i=0;i<itemNum;i++){
                if (itemDatas[i] == null) break;
                else if (itemDatas[i].key.compareTo(key)==0) {
                    return i;
                }
            }
            return -1;
        }

        // 向该结点插入键值对：前提是结点未满
        private int insertData(Data data) {
            itemNum++;
            for (int i = N-2;i>0;i--){
                if (itemDatas[i]==null){
                    continue;
                }else {
                    if (data.key.compareTo(itemDatas[i].key)<0){
                        itemDatas[i+1] =itemDatas[i];
                    }else{
                        itemDatas[i+1] =data;
                        return i+1;
                    }
                }
            }
            itemDatas[0] =data;
            return 0;
        }

        // 移除最后一个键值对
        private Data removeItem(){
            Data temp = itemDatas[itemNum-1];
            itemDatas[itemNum-1] =null;
            itemNum--;
            return temp;
        }

        // 根结点
        private Node23 root = new Node23();

        // 查找含有key的键值对
        public Value find(Key key) {
            return null;
        }

        // 在key的条件下获得结点的子结点

        // 插入函数

        // 裂变函数

        // 链接node和parent



    }
}
