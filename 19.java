//两个指针，先固定两指针之间的差值，再移动寻找到要删除的元素进行删除操作
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy;
        for(int i = 0; i < n + 1; i++){
            l2 = l2.next;
        }
        while(l2 != null){
            l2 = l2.next;
            l1 = l1.next;
        }
        l1.next = l1.next.next;
        return dummy.next;
    }
}