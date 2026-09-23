package DSAQuestions;

public class reverselinkedlist {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);


        while(node.next!=null)
        {
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println("null");

        ListNode current = node;

        ListNode prev = null;
    }
}
