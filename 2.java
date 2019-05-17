//依次遍历两个链表，相加，进位，注意最后不要漏掉加法进位
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode cur = dummy;
        int sign = 0;
        while(cur1 != null || cur2 != null){
            int tmp = 0;
            if(cur1 != null){
                tmp += cur1.val;
                cur1 = cur1.next;
            }
            if(cur2 != null){
                tmp += cur2.val;
                cur2 = cur2.next;
            }
            tmp += sign;
            sign = tmp / 10;;
            tmp %= 10;
            ListNode newNode = new ListNode(tmp);
            cur.next = newNode;
            cur = cur.next;
        }
        if(sign != 0){
            cur.next = new ListNode(sign);
        }
        return dummy.next;
    }
}