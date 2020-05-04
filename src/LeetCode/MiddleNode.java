package LeetCode;

public class MiddleNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
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
