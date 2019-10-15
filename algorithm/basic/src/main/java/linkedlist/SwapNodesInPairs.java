package linkedlist;

/**
 * @author cvictory ON 2019-05-28
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode node = prev;
        while (node.next != null && node.next.next != null) {
            ListNode twoNext = node.next.next.next;
//            ListNode listNode = head;
            ListNode secondNode = node.next.next;
            ListNode firstNode = node.next;
            secondNode.next = firstNode;
            firstNode.next = twoNext;

            node.next = secondNode;

            node = firstNode;
        }
        return prev.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
