package DSAQuestions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class removelooplinkedlist {

    static void removeloop(ListNode head)
    {
        Set<ListNode> visted = new HashSet<>();

        ListNode current = head;
        ListNode prev = null;

        while (current!=null)
        {
            if(visted.contains(current))
            {
                prev.next =null;
                return;
            }

            visted.add(current);
            prev =current;
            current =current.next;
        }
    }

    static void printloop(ListNode head)
    {
        ListNode current = head;

        while(current!= null)
        {
            System.out.print(current.val+" -> ");
            current = current.next;
        }

        System.out.println("null");
    }
    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = second;

     removelooplinkedlist.removeloop(first);

     removelooplinkedlist.printloop(first);

    }
}
