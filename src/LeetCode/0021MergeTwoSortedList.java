package LeetCode;

class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode result;
        if(list1.val <= list2.val){
            result = list1;
        } else{
            result = list2;
        }
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val && list1.next != null && list1.next.val < list2.val){
                list1 = list1.next;
            } else if(list1.val <= list2.val){
                ListNode temp = list1.next;
                list1.next = list2;
                list1 = list2;
                list2 = temp;
            } else {
                ListNode temp = list1;
                list1 = list2;
                list2 = temp;
            }
        }
        return result;
    }
}
