package threadpools;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * A fixed thread pool keeps a constant number of threads alive for the life of
 * the pool. Extra tasks wait in an unbounded queue instead of spawning new
 * threads, so submitting more tasks than the pool size just makes them queue
 * up and run in waves.
 */
public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        int poolSize = 4;
        int taskCount = 12;

        Instant start = Instant.now();

        try (ExecutorService executor = Executors.newFixedThreadPool(poolSize)) {
            IntStream.range(0, taskCount)
                    .forEach(taskId -> executor.submit(() -> process(taskId)));
        }

        Instant end = Instant.now();
        System.out.println("Completed " + taskCount + " tasks on a fixed pool of "
                + poolSize + " threads in " + Duration.between(start, end).toMillis() + " ms");
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
