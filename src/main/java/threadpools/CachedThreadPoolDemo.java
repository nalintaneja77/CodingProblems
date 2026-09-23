package threadpools;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * A cached thread pool creates a new thread for every task if none are idle,
 * and reuses idle threads that finished within the last 60 seconds. Unlike a
 * fixed pool, there is no cap, so bursting many tasks at once runs them all
 * in parallel on their own threads rather than queueing.
 */
public class CachedThreadPoolDemo {

    public static void main(String[] args) {
        int taskCount = 12;

        Instant start = Instant.now();

        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, taskCount)
                    .forEach(taskId -> executor.submit(() -> process(taskId)));
        }

        Instant end = Instant.now();
        System.out.println("Completed " + taskCount + " tasks on a cached pool in "
                + Duration.between(start, end).toMillis() + " ms");
    }

    static void process(int taskId) {
        System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
        try {
            Thread.sleep(Duration.ofMillis(500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
