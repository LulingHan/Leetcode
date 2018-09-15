/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;

        // compare int by int
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                temp.next = l1;                
                l1 = l1.next;
            }
            else{
                temp.next = l2;                
                l2 = l2.next;
            }
            temp = temp.next;
        }
        // l1 and l2 will not to end simul(不会同时到达链表末端)
        if(l1 == null && l2 != null){   
            // can use for loop, but slow         
            // for(ListNode i = l2; i != null; i = i.next){
            //     temp.next = l2;
            //     temp = temp.next;
            //     l2 = l2.next;
            // }
            temp.next = l2;  // not temp = l2 !
        }
        else{
            // for(ListNode i = l1; i != null; i = i.next){               
            //     temp.next = l1;
            //     temp = temp.next;
            //     l1 = l1.next;
            // }
            temp.next = l1;
        }
        return result.next;
    }
        
}

