class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Dummy node makes connecting groups easier
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = getKthNode(groupPrev, k);

            // Not enough nodes left
            if (kth == null) {
                break;
            }

            // Save the node after the current group
            ListNode groupNext = kth.next;

            // Reverse the group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group to reversed group
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;

            // Move groupPrev to the end of the reversed group
            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
