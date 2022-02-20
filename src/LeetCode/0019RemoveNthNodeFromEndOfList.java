package LeetCode;

class RemoveNthNodeFromEndOfList {
    //My solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i < n; i++){
            if(second.next == null){
                return head.next;
            }
            second = second.next;
        }
        while(second.next != null){
            second = second.next;
            first = first.next;
        }

        if(n == 1){
            first.next = null;
        }else{
            first.next = first.next.next;
        }
        return head;
    }

    //Cleaner solution by initializing a pointer before the head
    public ListNode removeNthFromEndCleaner(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
