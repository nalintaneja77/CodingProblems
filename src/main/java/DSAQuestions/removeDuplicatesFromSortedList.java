package DSAQuestions;

public class removeDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;
            while(current!=null && current.next!=null) {
                if (current.val == current.next.val) {
                    ListNode newNode = current.next.next;
                    current.next = newNode;
                } else {
                    current = current.next;
                }
            }
            return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(3);
        removeDuplicatesFromSortedList bb =new removeDuplicatesFromSortedList();
        bb.deleteDuplicates(head1);
    }

}
