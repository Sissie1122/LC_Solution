//先拆分，再合并
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;
        int pos = 0;
        while(cur != null){
            if(pos % 2 == 0){
                cur1.next = cur;
                cur1 = cur1.next;
            }
            else{
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
            pos = (pos + 1) % 2;
        }
        cur1.next = null;
        cur2.next = null;
        cur1 = dummy1.next;
        cur2 = dummy2.next;
        ListNode resDummy = new ListNode(0);
        cur = resDummy;
        while(cur1 != null || cur2 != null){
            if(cur2 != null){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
            if(cur1 != null){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
        }
        cur.next = null;
        return resDummy.next;
    }
}