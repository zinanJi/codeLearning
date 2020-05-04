package LeetCode.owner.LinkedList;

/**
 * Created by zinan.ji on 2020-04-23.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        else if (head.next==null) return head;

        ListNode odd = new ListNode(0);
        ListNode oddCur = odd;
        ListNode even = new ListNode(0);
        ListNode evenCur = even;
        int i = 1;
        while (head!=null) {

            if (i%2!=0){
                oddCur.next = new ListNode(head.val);
                oddCur = oddCur.next;
            }else {
                evenCur.next = new ListNode(head.val);
                evenCur = evenCur.next;
            }
            head = head.next;
            i++;

        }
        oddCur.next = even.next;
        return  odd.next;
    }
}
