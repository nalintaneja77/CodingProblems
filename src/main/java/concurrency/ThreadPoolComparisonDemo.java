package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Entry point: builds N identical "slow" tasks, runs them single-threaded,
 * then runs them again through an ExecutorService thread pool.
 *
 * Watch the thread names printed by Task:
 *  - single-threaded run: every line says the same thread, e.g. [main]
 *  - executor run: lines interleave across pool-1-thread-1, pool-1-thread-2, ...
 *    and several "STARTED" lines appear before the first "FINISHED" line,
 *    proving tasks are genuinely overlapping in time.
 */
public class ThreadPoolComparisonDemo {

    private static final int TASK_COUNT = 8;
    private static final long TASK_DURATION_MS = 1000;
    private static final int POOL_SIZE = 4;

    public static void main(String[] args) throws Exception {
        List<Callable<String>> singleThreadTasks = buildTasks();
        List<Callable<String>> executorTasks = buildTasks();

        SingleThreadedRunner.run(singleThreadTasks);
        ExecutorFrameworkRunner.run(executorTasks, POOL_SIZE);

        System.out.println("\n=== Takeaway ===");
        System.out.printf("%d tasks x %dms each.%n", TASK_COUNT, TASK_DURATION_MS);
        System.out.printf("Single-threaded is expected to take ~%d ms (sum of every task).%n",
                TASK_COUNT * TASK_DURATION_MS);
        System.out.printf("Executor with a pool of %d is expected to take ~%d ms (tasks overlap).%n",
                POOL_SIZE, (long) Math.ceil((double) TASK_COUNT / POOL_SIZE) * TASK_DURATION_MS);
    }

    private static List<Callable<String>> buildTasks() {
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 1; i <= TASK_COUNT; i++) {
            tasks.add(new Task(i, TASK_DURATION_MS));
        }
        return tasks;
    }
}
