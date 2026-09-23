package concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Runs the same tasks through a fixed thread pool. Several tasks sleep at the
 * SAME TIME on different pool threads, so total time is roughly
 * (number of tasks / poolSize) * task duration instead of the full sum.
 */
public class ExecutorFrameworkRunner {

    public static void run(List<Callable<String>> tasks, int poolSize) throws Exception {
        System.out.printf("%n=== ExecutorService run (thread pool of %d) ===%n", poolSize);
        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        try {
            // invokeAll submits every task and blocks until all are done,
            // but the tasks themselves run concurrently across pool threads.
            List<Future<String>> futures = executor.invokeAll(tasks);

            for (Future<String> future : futures) {
                future.get(); // surfaces any exception the task threw
            }
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }

        long elapsed = System.currentTimeMillis() - start;
        System.out.printf("Executor total time: %d ms%n", elapsed);
    }
}
