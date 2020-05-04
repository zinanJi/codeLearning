package LeetCode.owner.LinkedList;

/**
 * Created by zinan.ji on 2020-04-19.
 * 206. 反转链表
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode p = null, tmp;
        while (head != null) {
            // tmp 保存下个节点
            tmp = head.next;
            // 断开原有next，把next指向上一个结点就是p
            head.next = p;
            // 往后走当前head就成了上一个结点p
            p = head;
            // 原本存储下一个节点的tmp就成了下一个循环的当前head
            head = tmp;
        }
        return p;
    }
}
