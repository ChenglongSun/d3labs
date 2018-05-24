/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode head = null;
        TreeLinkNode node = null;
        
        while (cur != null) {
            if (cur.left != null) {
                if (head == null) {
                    head = cur.left;
                } else {
                    node.next = cur.left;
                }
                node = cur.left;
            }
            if (cur.right != null) {
                if (head == null) {
                    head = cur.right;
                } else {
                    node.next = cur.right;
                }
                
                node = cur.right;
            }
            cur = cur.next;
            if (cur == null && head != null) {
                cur = head;
                head = null;
                node = null;
            }
        }
    }
}