package LeetCode;
import java.util.*;

class LinkedListCycle {
    //My HashMap solution, albeit slower
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        for(int i = 0; head != null; i++){
            if(map.containsKey(head)){
                return true;
            }else{
                map.put(head, i);
            }
            head = head.next;
        }
        return false;
    }

    //Two pointer, one faster than the other, if there is a cycle, they will eventually meet
    public boolean hasCycleFaster(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }
}
