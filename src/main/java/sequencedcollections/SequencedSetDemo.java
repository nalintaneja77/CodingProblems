package sequencedcollections;

import java.util.LinkedHashSet;
import java.util.SequencedSet;
import java.util.TreeSet;

/**
 * Before Java 21, LinkedHashSet had a defined iteration order (insertion order)
 * but NO way to directly read the first/last element or iterate backwards —
 * you had to grab an Iterator and walk it manually. SequencedSet fixes that.
 */
public class SequencedSetDemo {

    public static void run() {
        System.out.println("=== SequencedSetDemo ===");

        // LinkedHashSet keeps insertion order and now implements SequencedSet
        SequencedSet<Integer> visitedPageIds = new LinkedHashSet<>();
        visitedPageIds.add(101);
        visitedPageIds.add(205);
        visitedPageIds.add(310);
        visitedPageIds.add(205); // duplicate, ignored — still a Set

        System.out.println("Visited pages (insertion order): " + visitedPageIds);
        System.out.println("First visited: " + visitedPageIds.getFirst());
        System.out.println("Last visited: " + visitedPageIds.getLast());
        System.out.println("Most recent first (reversed view): " + visitedPageIds.reversed());

        // TreeSet keeps sorted order and also implements SequencedSet
        SequencedSet<Integer> sortedScores = new TreeSet<>();
        sortedScores.add(72);
        sortedScores.add(15);
        sortedScores.add(93);
        sortedScores.add(40);

        System.out.println("Sorted scores: " + sortedScores);
        System.out.println("Lowest score: " + sortedScores.getFirst());
        System.out.println("Highest score: " + sortedScores.getLast());
        System.out.println("Descending view: " + sortedScores.reversed());

        System.out.println();
    }
}
