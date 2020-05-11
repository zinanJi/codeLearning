package LeetCode.owner.dualPointer;

import LeetCode.owner.LinkedList.ListNode;

/**
 * Created by zinan.ji on 2020-05-11.
 */
public class DetectCycle_142 {
    public ListNode detectCycle(ListNode head) {

        ListNode fast, slow;
        fast = slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        // fast走了2k步，slow走了k步
        // 此时相遇时离环起点有m步
        // fast在相遇点再走k-m步返回环起点，slow再从head走k-m步就能走到环起点
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
