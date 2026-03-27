package Heaps;
public class MergeKSortedLists {
  // lc-23 Merge k Sorted Lists
   public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>min=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list:lists)if(list!=null)min.add(list);
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        while(!min.isEmpty()){
            ListNode curr=min.remove();
            ListNode next=curr.next;
            curr.next=null;
            dummy.next=curr;
            dummy=dummy.next;
            if(next!=null){
                min.add(next);
            }
        }
        return ans.next;
    }
}