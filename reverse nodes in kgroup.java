/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                count--;
            }
            head = curr;
        }
        return head;
    }
}