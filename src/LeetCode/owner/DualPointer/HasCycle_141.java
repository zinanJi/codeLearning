package LeetCode.owner.DualPointer;

import LeetCode.owner.LinkedList.ListNode;


/**
 * Created by zinan.ji on 2020-05-11.
 */
public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast!=null&&fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast) return true;
        }
        return false;
    }
}
