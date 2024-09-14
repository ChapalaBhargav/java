import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPriority {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create and submit tasks with different priorities
        executor.submit(new PriorityRunnable("High Priority Thread", Thread.MAX_PRIORITY));
        executor.submit(new PriorityRunnable("Normal Priority Thread", Thread.NORM_PRIORITY));
        executor.submit(new PriorityRunnable("Low Priority Thread", Thread.MIN_PRIORITY));

        // Shutdown the executor after all tasks are completed
        executor.shutdown();
    }
}

class PriorityRunnable implements Runnable {
    private final String threadName;
    private final int priority;

    public PriorityRunnable(String threadName, int priority) {
        this.threadName = threadName;
        this.priority = priority;
    }

    @Override
    public void run() {
        // Set the thread's priority
        Thread.currentThread().setPriority(priority);

        System.out.println(threadName + " started with priority " + Thread.currentThread().getPriority());

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " is running - " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
            Thread.currentThread().interrupt(); // Restore the interrupt status
        }

        System.out.println(threadName + " finished.");
    }
}
