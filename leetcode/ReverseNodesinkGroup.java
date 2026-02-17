public class ReverseNodesinkGroup {
  // lc-25
  class Solution {
    class ListNode{
      int val;
      ListNode next;
      ListNode(int val){
        this.val=val;
      }
    }
    public ListNode helper(ListNode head, int i, int j, int n, int k) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;

        for (int l = 1; l < i; l++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next = curr.next;

        for (int count = 1; count < k; count++) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        return temp.next;

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        for (int i = 0; i < n; i += k) {
            if (i + k <= n) {
                head = helper(head, i + 1, i + k - 1, n, k);
            }
        }
        return head;
    }
}
}
