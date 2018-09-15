// merge one by one in suuccession.  136ms
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;

        if(length ==0){
        	return null;
        }
        else if(length == 1) {
        	return lists[0];
        }
        else if(length == 2){
        	return mergetwo(lists[0], lists[1]);
        }
        else{
        	ListNode temp = mergetwo(lists[0], lists[1]);
        	for(int i=2; i<length; ++i){

	        	ListNode temp2 = mergetwo(temp, lists[i]);
	        	temp = temp2;
        	}
        }

    }
    private ListNode mergetwo(ListNode l1, ListNode l2){

    	ListNode result = new ListNode(-1);
    	ListNode temp = result;

    	while(l1 != null && l2 != null){
    		if(l1.val >= l2.val){
    			temp.next = l2;
    			l2 = l2.next;
    		}
    		else{
    			temp.next = l1;
    			l1 = l1.next;
    		}
    		temp = temp.next;
    	}

    	if(l1 == null){temp.next = l2;}
    	else{temp.next = l1;}

    	return result.next;
    }

}