/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(!head || !head->next)return head; //base condition

        //swap nodes
        ListNode* temp = head; // store head
        ListNode* temp1 = head->next->next; //store head->next->next
        head = head->next; // swap head and next node
        head->next = temp; // new head's next = old head (temp)
        head->next->next = swapPairs(temp1); // head->next->next = recursive call
        return head; // no backtracking needed just return the head
    }
};