package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Runs every task one after another on the calling thread.
 * Total time is roughly the SUM of every task's duration -
 * there is nothing else for the CPU to do while one task sleeps.
 */
public class SingleThreadedRunner {

    public static void run(List<Callable<String>> tasks) throws Exception {
        System.out.println("\n=== Single-threaded run (one thread doing everything) ===");
        long start = System.currentTimeMillis();

        List<String> results = new ArrayList<>();
        for (Callable<String> task : tasks) {
            results.add(task.call());
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Results: " + results);
        System.out.printf("Single-threaded total time: %d ms%n", elapsed);
    }
}
