package DivideAndConquer&Conquer;

public class SortList {
  // lc-148 Sort List
class Solution {
    public ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next=null;

        ListNode leftSingle = mergeSort(left);
        ListNode rightSingle = mergeSort(right);

        return merge(leftSingle, rightSingle);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                dummy = dummy.next;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
                dummy = dummy.next;
            }
        }
        while (left != null) {
            dummy.next = left;
            dummy = dummy.next;
            left = left.next;
        }
        while (right != null) {
            dummy.next = right;
            right = right.next;
            dummy = dummy.next;
        }

        return head.next;
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
}
