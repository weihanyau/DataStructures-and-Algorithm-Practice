package LeetCode;

import java.math.BigInteger;

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        boolean carry = false;
        ListNode result = l1;
        while(l1 != null){
            if(l2 != null){
                l1.val += l2.val;
            }
            if(carry){
                l1.val += 1;
                carry = false;
            }
            if(l1.val > 9){
                l1.val %= 10;
                carry = true;
            }
            if(carry && l1.next == null){
                l1.next = new ListNode(0);
            }
            if(l2 != null){
                if(l2.next != null && l1.next == null){
                    l1.next = new ListNode(0);
                }
                l2 = l2.next;
            }
            l1 = l1.next;
        }
        return result;
    }

    public ListNode addTwoNumbersBigInteger(ListNode l1, ListNode l2) {
        BigInteger values = BigInteger.ZERO;
        int l1Size = 0, l2Size = 0;
        ListNode temp = l1;
        while(temp != null){
            l1Size++;
            temp = temp.next;
        }
        temp = l2;
        while(temp != null){
            l2Size++;
            temp = temp.next;
        }

        temp = l1;
        for(int i = 0; i < l1Size; i++){
            values = values.add(BigInteger.valueOf(temp.val).multiply(BigInteger.valueOf(10).pow(i)));
            temp = temp.next;
        }

        temp = l2;
        for(int i = 0; i < l2Size; i++){
            values = values.add(BigInteger.valueOf(temp.val).multiply(BigInteger.valueOf(10).pow(i)));
            temp = temp.next;
        }
        System.out.println(values);
        ListNode result = new ListNode();
        temp = result;
        temp.val = values.mod(BigInteger.TEN).intValue();
        values = values.divide(BigInteger.TEN);
        while(values.compareTo(BigInteger.ZERO) == 1)
        {
            temp.next = new ListNode(values.mod(BigInteger.TEN).intValue());
            values = values.divide(BigInteger.TEN);
            temp = temp.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}