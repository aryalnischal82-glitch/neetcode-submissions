/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        //two parts: split from middle, reverse second half, merge first and second half one by one
        //to find middle, use fast and slow pointer 
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow 
        ListNode seconHalfBegin=slow.next;
        slow.next=null;

        ListNode l1=head;
        ListNode l2=reverseList(seconHalfBegin);

        //merge
        ListNode res=new ListNode(-1);
        ListNode dummy=res;
        while(l1!=null && l2!=null){
            res.next=l1;
            l1=l1.next;
            res=res.next;
            res.next=l2;
            l2=l2.next;
            res=res.next;
        }
        while(l1!=null){
            res.next=l1;
            l1=l1.next;
            res=res.next;
        }
        while(l2!=null){
            res.next=l2;
            l2=l2.next;
            res=res.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }

    


}
