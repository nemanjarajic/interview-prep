package Facebook;

public class mergeTwoSortedLists {
    public static ListNode solution(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode temp = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if(l2 != null) temp.next = l2;
        else if(l1 != null) temp.next = l1;

        return head.next;
    }
}
