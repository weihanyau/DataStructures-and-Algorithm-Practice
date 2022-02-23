package LeetCode;

class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            } else{
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
