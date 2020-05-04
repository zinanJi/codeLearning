package LeetCode.HOT100.linkedlist;

/**
 * Created by zinan.ji on 2020-04-14.
 * 445. 两数相加 II
 */
public class AddTwoNumbers2_455 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode res = null;
        // 指针pre,生成新res的时候反指前一个指针
        ListNode pre = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            pre = res;
            res = new ListNode(sum % 10);
            res.next = pre;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            pre = res;
            res = new ListNode(carry);
            res.next = pre;
        }
        return res;

    }

    private ListNode reverseList(ListNode node) {
        ListNode reverse = null;
        ListNode temp;
        while (node != null) {
            temp = node.next;
            node.next = reverse;
            reverse = node;
            node = temp;
        }
        return reverse;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return new ListNode(0);
    }
}
