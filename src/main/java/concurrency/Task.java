package concurrency;

import java.util.concurrent.Callable;

/**
 * Simulates a unit of work that takes real time (e.g. an I/O call, a DB query).
 * The sleep is what makes single-threaded vs pooled execution visibly different -
 * without some blocking delay, everything finishes "instantly" either way.
 */
public class Task implements Callable<String> {

    private final int id;
    private final long workMillis;

    public Task(int id, long workMillis) {
        this.id = id;
        this.workMillis = workMillis;
    }

    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.printf("Task-%d STARTED  on [%s] at %s%n", id, threadName, now());
        Thread.sleep(workMillis);
        System.out.printf("Task-%d FINISHED on [%s] at %s%n", id, threadName, now());
        return "Result of Task-" + id;
    }

    private static String now() {
        return java.time.LocalTime.now().withNano(0) + "." +
                (System.currentTimeMillis() % 1000);
    }
}
