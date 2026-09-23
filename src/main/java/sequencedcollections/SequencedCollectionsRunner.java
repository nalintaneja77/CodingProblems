package sequencedcollections;

/**
 * Entry point that runs every SequencedCollection demo in this package in order.
 * Run this class's main() to see List, Set, Map and the LRU cache examples together.
 */
public class SequencedCollectionsRunner {
    public static void main(String[] args) {
        SequencedListDemo.run();
        SequencedSetDemo.run();
        SequencedMapDemo.run();
        LRUCacheUsingSequencedMap.run();
    }
}
