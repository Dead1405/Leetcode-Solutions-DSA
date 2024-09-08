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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> ans;
        int len = 0;
        ListNode* temp = head;
        while(temp != NULL){
            len++;
            temp = temp->next;
        }
        int newLen = len / k;
        int left = len % k;
        for(int i = 0; i < min(k,len); i++){
            ans.push_back(head);
            for(int j = 0 ; j < newLen; j++){
                temp = head;
                head = head->next;
            }
            if(left){
                temp = head;
                head = head->next;
                left--;
            }
            temp->next = NULL;
        }
        while(ans.size() != k){
            ans.push_back(NULL);
        }
        return ans;
    }
};