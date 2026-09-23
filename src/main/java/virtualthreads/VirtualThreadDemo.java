package virtualthreads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadDemo {

    public static void main(String[] args) {
        int taskCount = 10_000;

        Instant start = Instant.now();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, taskCount)
                    .forEach(orderId -> executor.submit(() -> fetchOrderStatus(orderId)));
        }

        Instant end = Instant.now();
        System.out.println("Completed " + taskCount + " blocking calls in "
                + Duration.between(start, end).toMillis() + " ms, using thread: "
                + Thread.currentThread());
    }

    static String fetchOrderStatus(int orderId) {
        try {
            Thread.sleep(Duration.ofMillis(500));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Order " + orderId + " -> SHIPPED";
    }
}
