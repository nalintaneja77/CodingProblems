package sequencedcollections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Real-world use case: an LRU (Least Recently Used) cache.
 *
 * Before SequencedMap, evicting the eldest entry from a LinkedHashMap required
 * grabbing entrySet().iterator().next() — awkward and easy to get wrong.
 * Now it's a single call: pollFirstEntry().
 */
public class LRUCacheUsingSequencedMap<K, V> {

    private final int capacity;
    private final LinkedHashMap<K, V> store;

    public LRUCacheUsingSequencedMap(int capacity) {
        this.capacity = capacity;
        // accessOrder = true: get() moves the accessed entry to the end (most recently used)
        this.store = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public V get(K key) {
        return store.get(key);
    }

    public void put(K key, V value) {
        store.put(key, value);
        if (store.size() > capacity) {
            // The least-recently-used entry is always the first entry —
            // SequencedMap makes evicting it a one-liner instead of an iterator dance.
            Map.Entry<K, V> evicted = store.pollFirstEntry();
            System.out.println("Evicting least-recently-used entry: " + evicted);
        }
    }

    @Override
    public String toString() {
        return store.toString();
    }

    public static void run() {
        System.out.println("=== LRUCacheUsingSequencedMap (real-world use case) ===");

        LRUCacheUsingSequencedMap<String, String> cache = new LRUCacheUsingSequencedMap<>(3);
        cache.put("user:1", "Alice");
        cache.put("user:2", "Bob");
        cache.put("user:3", "Charlie");
        System.out.println("Cache after 3 inserts: " + cache);

        // Access user:1, marking it as most recently used
        cache.get("user:1");
        System.out.println("Cache after accessing user:1: " + cache);

        // Insert a 4th entry — this should evict user:2 (least recently used, since user:1 was just touched)
        cache.put("user:4", "Dave");
        System.out.println("Cache after inserting user:4: " + cache);

        System.out.println();
    }
}
