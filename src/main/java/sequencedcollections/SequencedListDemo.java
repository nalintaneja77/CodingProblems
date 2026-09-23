package sequencedcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

/**
 * Demonstrates SequencedCollection (JEP 431, Java 21) via List.
 * List already had first/last access, but it needed different method
 * names (get(0), get(size()-1)) and manual reversal. SequencedCollection
 * standardizes this across every ordered collection type.
 */
public class SequencedListDemo {

    public static void run() {
        System.out.println("=== SequencedListDemo ===");

        SequencedCollection<String> names = new ArrayList<>(List.of("Bob", "Charlie", "Dave"));

        // addFirst / addLast : insert without knowing the list's internal index scheme
        names.addFirst("Alice");
        names.addLast("Eve");
        System.out.println("After addFirst/addLast: " + names);

        // getFirst / getLast : no more get(0) / get(size()-1)
        System.out.println("First: " + names.getFirst());
        System.out.println("Last: " + names.getLast());

        // reversed() returns a VIEW, not a copy — no Collections.reverse() needed
        SequencedCollection<String> reversedView = names.reversed();
        System.out.println("Reversed view: " + reversedView);

        // Prove it's a live view: mutating the original is reflected in the view
        names.addLast("Frank");
        System.out.println("Original after adding Frank: " + names);
        System.out.println("Reversed view now shows Frank first: " + reversedView);

        // removeFirst / removeLast
        names.removeFirst();
        names.removeLast();
        System.out.println("After removeFirst/removeLast: " + names);

        System.out.println();
    }
}
