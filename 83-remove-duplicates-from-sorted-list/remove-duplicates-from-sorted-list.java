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
    public ListNode deleteDuplicates(ListNode head) {
        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        // Pointer to traverse the linked list
        ListNode pre = head;

        // Traverse until the last node
        while (pre != null && pre.next != null) {

            // If current node and next node have same value
            if (pre.val == pre.next.val) {

                // Skip the duplicate node
                pre.next = pre.next.next;

            } else {

                // Move to the next node
                pre = pre.next;
            }
        }

        // Return updated linked list
        return head;

    }
}