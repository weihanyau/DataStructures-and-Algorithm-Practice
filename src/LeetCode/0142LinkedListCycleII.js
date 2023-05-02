/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    if(head === null){
      return null;
    }
    let slow = head;
    let fast = head.next;

    while(slow !== fast){
      if(fast === null || fast === undefined) return null;
      slow = slow?.next;
      fast = fast?.next?.next;
    }

    let dummy = new ListNode(null, head);
    while(dummy !== slow){
      dummy = dummy.next;
      slow = slow.next;
    }
    return dummy;
};

