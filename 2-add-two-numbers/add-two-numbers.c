/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    
    int overflow = 0;
    struct ListNode *head = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode *curr = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode *temp = (struct ListNode*)malloc(sizeof(struct ListNode));
    curr = head;
    temp = l2;

    for(struct ListNode* i = l1; i != NULL; i = i->next){
    	if(temp != NULL){
    		curr->val = (l1->val + temp->val + overflow) % 10;
    		curr->next = (struct ListNode*)malloc(sizeof(struct ListNode));
    		curr = curr->next;
    		overflow = (l1->val + temp->val) / 10;
    		temp = temp->next;
    	}
    	else{
    		curr->val = (l1->val + overflow) % 10;
    		curr->next = (struct ListNode*)malloc(sizeof(struct ListNode));
    		curr = curr->next;
    		overflow = 0;
    	}
    }

    while(temp != NULL){
    	curr->val = (temp->val + overflow) % 10;
    	if(temp->next != NULL){
    		curr->next = curr->next = (struct ListNode*)malloc(sizeof(struct ListNode));
    		curr = curr->next;
    		temp = temp->next;
    	}
    	overflow = 0;
    }
    
}