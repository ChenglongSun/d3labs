/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        //find m - 1
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode first = pre.next;
        ListNode second = first.next;
        
        for (int i = 0; i < n - m; i++) {          
            first.next = second.next;
            second.next = pre.next;
            pre.next = second;
            second = first.next;
        }
        
        return dummy.next;
    }
}