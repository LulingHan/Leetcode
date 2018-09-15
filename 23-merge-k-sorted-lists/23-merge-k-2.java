//  类似二分法合并 11ms
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
        return iterate(lists);
   }

    public ListNode iterate(ListNode[] lists){ 

        int length = lists.length;
        int new_len = -1;

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
            if(length % 2 == 0){
                new_len = length / 2;
                ListNode[] new_list = new ListNode[new_len];
                for(int i=0; i<new_len; ++i){
                    new_list[i] = mergetwo(lists[i], lists[length -1 - i]);
                }
                return iterate(new_list);
            }
            else{
                new_len = length / 2 + 1;
                ListNode[] new_list = new ListNode[new_len];
                for(int i=0; i<new_len-1; ++i){
                    new_list[i] = mergetwo(lists[i], lists[length -1 - i]);
                }
                new_list[new_len - 1] = lists[new_len - 1];
                return iterate(new_list);
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

        if(l1 == null){
            temp.next = l2;
        }
        else{
            temp.next = l1;
        }

        return result.next;
    }
        
}