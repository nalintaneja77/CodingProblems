package hashequalscontract;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Demonstrates what goes wrong in a HashMap when the hashCode/equals contract is broken.
 * Run main() and read the printed output alongside the comments.
 */
public class HashCodeEqualsContractDemo {

    // ---------- Case 1: equals() says "equal", but hashCode() disagrees ----------
    static class BadKey1 {
        final int id;
        BadKey1(int id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof BadKey1)) return false;
            return this.id == ((BadKey1) o).id;
        }

        @Override
        public int hashCode() {
            // BROKEN: ignores id entirely, so two "equal" keys can land in different buckets
            return (int) (Math.random() * 1000);
        }
    }

    // ---------- Case 2: equals() is broken (always false) ----------
    static class BadKey2 {
        final int id;
        BadKey2(int id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            // BROKEN: never considers any two instances equal, even with same id
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id); // consistent, but equals() undermines it
        }
    }

    // ---------- Case 3: correct contract, but key is mutated after insertion ----------
    static class MutableKey {
        int id; // not final on purpose
        MutableKey(int id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MutableKey)) return false;
            return this.id == ((MutableKey) o).id;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        @Override
        public String toString() {
            return "MutableKey(" + id + ")";
        }
    }

    // ---------- A correctly implemented key, for comparison ----------
    static class GoodKey {
        final int id;
        GoodKey(int id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GoodKey)) return false;
            return this.id == ((GoodKey) o).id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {
        caseOne_hashCodeIgnoresEquals();
        caseTwo_equalsAlwaysFalse();
        caseThree_mutatedKeyAfterInsertion();
        caseFour_correctContract();
    }

    private static void caseOne_hashCodeIgnoresEquals() {
        System.out.println("=== Case 1: equals() true, hashCode() differs ===");
        Map<BadKey1, String> map = new HashMap<>();
        BadKey1 key1 = new BadKey1(42);
        map.put(key1, "first value");

        BadKey1 key2 = new BadKey1(42); // key2.equals(key1) is true
        System.out.println("key1.equals(key2): " + key1.equals(key2));
        System.out.println("get(key2) result : " + map.get(key2)); // usually null: wrong bucket
        map.put(key2, "second value");  // usually adds a NEW entry instead of overwriting
        System.out.println("map size after second put (expected 1, likely 2): " + map.size());
        System.out.println();
    }

    private static void caseTwo_equalsAlwaysFalse() {
        System.out.println("=== Case 2: equals() always returns false ===");
        Map<BadKey2, String> map = new HashMap<>();
        map.put(new BadKey2(1), "first value");
        map.put(new BadKey2(1), "second value"); // "same" id, but equals() says not equal
        System.out.println("map size after inserting two 'equal' id=1 keys (expected 1, actual): " + map.size());
        System.out.println();
    }

    private static void caseThree_mutatedKeyAfterInsertion() {
        System.out.println("=== Case 3: mutable key changed after insertion ===");
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey(1);
        map.put(key, "original");
        System.out.println("get with original id: " + map.get(new MutableKey(1)));

        key.id = 2; // mutate the field hashCode()/equals() depend on
        System.out.println("get with new id (2), same object logically moved: " + map.get(new MutableKey(2)));
        System.out.println("get with old id (1): " + map.get(new MutableKey(1)));
        System.out.println("map still reports containsKey via iteration only; entrySet: " + map.entrySet());
        System.out.println();
    }

    private static void caseFour_correctContract() {
        System.out.println("=== Case 4: correct contract, for comparison ===");
        Map<GoodKey, String> map = new HashMap<>();
        map.put(new GoodKey(42), "first value");
        map.put(new GoodKey(42), "second value"); // correctly overwrites
        System.out.println("map size (expected 1): " + map.size());
        System.out.println("get(new GoodKey(42)): " + map.get(new GoodKey(42)));
    }
}
