package LeetCode;

class MiddleOfALinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(second != null){
            if(second.next != null){
                second = second.next.next;
            } else{
                break;
            }
            first = first.next;
        }
        return first;
    }
}
