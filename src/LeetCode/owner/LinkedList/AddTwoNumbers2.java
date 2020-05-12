package LeetCode.owner.LinkedList;

/**
 * Created by zinan.ji on 2020-04-13.
 * 2. 两数相加
 */
public class AddTwoNumbers2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static String print(ListNode l) {
            StringBuilder sb = new StringBuilder();
            while (l != null) {
                sb.append(l.val);
                l = l.next;
            }
            return sb.toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (flag > 0) cur.next = new ListNode(flag);
        return res;
    }

}
