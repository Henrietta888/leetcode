package leetcode;

/**
 * Created by Administrator on 2016/11/3.
 */
public class Solution2V1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode node, head;
        head = node = new ListNode(0);
        boolean isCarry = false;
        for (ListNode l1Node = l1, l2Node = l2; l1Node != null || l2Node != null; ) {
            node.val = (l1Node != null ? l1Node.val : 0) + (l2Node != null ? l2Node.val : 0);
            if (isCarry) {
                node.val += 1;
                isCarry = false;
            }
            if (node.val > 9) {
                node.val -= 10;
                isCarry = true;
            }

            l1Node = l1Node != null ? l1Node.next : null;
            l2Node = l2Node != null ? l2Node.next : null;
            if (l1Node != null || l2Node != null) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        if (isCarry) {
            node.next = new ListNode(1);
            isCarry = false;
        }

        return head;
    }


    public static void main(String[] args) {
        int[] i1 = {2, 4, 3};
        int[] i2 = {5, 6};
        Solution2V1 s = new Solution2V1();
        ListNode ln = s.addTwoNumbers(get(i1), get(i2));
        System.out.println(ln);
    }

    public static ListNode get(int[] array) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            node.val = i1;
            if (i < array.length - 1) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        System.out.println(head);
        return head;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            sb.append(node.val).append(" ");
            node = node.next;
        }
        return sb.toString();
    }
}