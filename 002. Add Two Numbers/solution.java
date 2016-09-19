/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode firstNode = new ListNode(sum % 10);
        ListNode tempNode = firstNode;
        ListNode zeroNode = new ListNode(0);
        while(l1.next != null || l2.next != null || sum >9) {
            if(l1.next != null)
                l1 = l1.next;
            else
                l1 = zeroNode;
            if(l2.next != null)
                l2 = l2.next;
            else
                l2 = zeroNode;
            
            sum = l1.val + l2.val + sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            tempNode.next = newNode;
            tempNode = tempNode.next;
        }
        return firstNode;
    }
}