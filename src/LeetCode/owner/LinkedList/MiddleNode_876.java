package LeetCode.owner.LinkedList;

/**
 * Created by zinan.ji on 2020-05-11.
 * 876. 链表的中间结点
 */
public class MiddleNode_876 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    
    // 前后指针
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null &&  fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }
}
