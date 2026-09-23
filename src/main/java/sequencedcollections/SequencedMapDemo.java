package sequencedcollections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SequencedMap;

/**
 * LinkedHashMap kept insertion order long before Java 21, but reading the
 * first/last entry meant pulling an Iterator off entrySet(). SequencedMap
 * gives it firstEntry()/lastEntry()/pollFirstEntry()/pollLastEntry()/reversed()
 * directly — the exact operations an eviction policy needs.
 */
public class SequencedMapDemo {

    public static void run() {
        System.out.println("=== SequencedMapDemo ===");

        SequencedMap<String, Integer> stockPrices = new LinkedHashMap<>();
        stockPrices.put("AAPL", 190);
        stockPrices.put("MSFT", 410);
        stockPrices.put("GOOG", 165);

        System.out.println("Insertion order: " + stockPrices);
        System.out.println("First entry: " + stockPrices.firstEntry());
        System.out.println("Last entry: " + stockPrices.lastEntry());

        // putFirst / putLast reposition regardless of prior insertion order
        stockPrices.putFirst("TSLA", 250);
        System.out.println("After putFirst(TSLA): " + stockPrices);

        // reversed() view — newest-inserted-looking-first, without rebuilding the map
        System.out.println("Reversed view: " + stockPrices.reversed());

        // pollFirstEntry / pollLastEntry remove-and-return in one call
        Map.Entry<String, Integer> removed = stockPrices.pollFirstEntry();
        System.out.println("Polled first entry: " + removed);
        System.out.println("Map after poll: " + stockPrices);

        System.out.println();
    }
}
