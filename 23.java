//法一：类似于merge sort的思想，不断二分，两两合并
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size == 0){
            return null;
        }
        return helper(lists, 0, size - 1);
    }
    
    private ListNode helper(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode head1 = helper(lists, start, mid);
        ListNode head2 = helper(lists, mid + 1, end);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
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
//法二：使用PriorityQueue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size == 0){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(size, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;    
            }
        });
        for(int i = 0; i < size; i++){
            if(lists[i] != null){
                heap.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!heap.isEmpty()){
            ListNode newNode = heap.poll();
            if(newNode.next != null){
                heap.offer(newNode.next);
            }
            cur.next = newNode;
            cur = cur.next;
        }
        return dummy.next;
    }
}