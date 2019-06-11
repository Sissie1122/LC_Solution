//helper返回的是下一段需要处理的链表前一个节点
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while(true){
            tmp = helper(tmp, k);
            if(tmp == null){
                break;
            }
            //System.out.println(tmp.val);
        }
        return dummy.next;
    }
    
    private ListNode helper(ListNode dummy, int k){
        ListNode nk = dummy;
        for(int i = 0; i < k; i++){
            nk = nk.next;
            if(nk == null){
                return null;
            }
        }
        ListNode n1 = dummy.next;
        dummy.next = nk;
        ListNode pre = nk.next;
        ListNode cur = n1;
        ListNode nextNode = null;
        while(pre != nk){
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return n1;
        
        
    }
}