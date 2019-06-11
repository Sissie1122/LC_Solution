//merge so'r't
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null || cur2 != null){
            int val1 = cur1 == null ? Integer.MAX_VALUE : cur1.val;
            int val2 = cur2 == null ? Integer.MAX_VALUE : cur2.val;
            if(val1 < val2){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
            else{
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        return dummy.next;
    }
}