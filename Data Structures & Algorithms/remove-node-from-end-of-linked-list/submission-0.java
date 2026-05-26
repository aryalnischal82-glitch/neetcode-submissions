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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr=head;
        int l=0;
        while(curr!=null){
            curr=curr.next;
            l++;
        }
        //k is kth position from beginning of list k->0,1,2...n
        int k=l-n;
        return removeNthFromBegin(head,k);

    }
    public ListNode removeNthFromBegin(ListNode head, int n){
        //to remove->nth index
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode curr=head;
        prev.next=curr;
        int i=0;
        while(curr!=null && i<n){
            prev=curr;
            curr=curr.next;
            i++;
        }
        prev.next=curr.next;
        return dummy.next;
    }
}
