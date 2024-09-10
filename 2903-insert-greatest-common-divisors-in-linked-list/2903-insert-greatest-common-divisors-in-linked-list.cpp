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
    // int hcf(int a,int b){
    //     if(a<b){
    //         if (b%a == 0) return a;
    //         else return hcf(b%a,a);
    //     }
    //     else{
    //         if(a%b == 0) return b;
    //         else return hcf(a%b,a);
    //     }
    // }
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        ListNode* temp = head;
        while(temp->next != NULL){
            temp->next =new ListNode(__gcd(temp->val,temp->next->val),temp->next);
            temp = temp->next->next;
        }
        return head;
    }
};