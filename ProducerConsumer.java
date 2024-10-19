import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private static final int BUFFER_SIZE = 10;
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Object lock = new Object();
    
    // Producer class
    class Producer extends Thread {
        private int item = 0;
        
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (buffer.size() == BUFFER_SIZE) {
                        try {
                            System.out.println("Buffer full, producer is waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    buffer.add(item++);
                    System.out.println("Produced: " + (item - 1));
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(1000); // Simulate time taken to produce an item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    // Consumer class
    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("Buffer empty, consumer is waiting...");
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    int item = buffer.poll();
                    System.out.println("Consumed: " + item);
                    lock.notifyAll();
                }
                try {
                    Thread.sleep(1500); // Simulate time taken to consume an item
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    public void start() {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
    }
    
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        pc.start();
    }
}

