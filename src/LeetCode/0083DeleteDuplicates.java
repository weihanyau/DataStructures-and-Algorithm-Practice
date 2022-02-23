package LeetCode;

class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        ListNode temp = dummy;
        dummy.next = head;
        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            } else{
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
