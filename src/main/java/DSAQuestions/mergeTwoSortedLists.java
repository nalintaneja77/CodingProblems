package DSAQuestions;

import java.util.List;

public class mergeTwoSortedLists {

    public  ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode handler = head;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                handler.next = list1;
                list1 = list1.next;
            } else {
                handler.next = list2;
                list2 = list2.next;
            }
            handler = handler.next;
        }

        if (list1 != null) {
            handler.next = list1;
        } else if (list2 != null) {
            handler.next = list2;
        }

        return head.next;

    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        mergeTwoSortedLists mm =new mergeTwoSortedLists();
        ListNode mergeHead = mm.mergeTwoLists(head1,head2);
        System.out.println(mergeHead);


    }
}
