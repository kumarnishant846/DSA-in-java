class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode d = new ListNode(0);

        while (head != null) {
            ListNode n = head;
            head = head.next;
            ListNode p = d;

            while (p.next != null && p.next.val < n.val)
                p = p.next;

            n.next = p.next;
            p.next = n;
        }
        return d.next;
    }
}