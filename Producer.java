class Storage {
    private int item;
    private boolean hasItem = false;
  
    public synchronized void addItem(int item) {
        while (hasItem) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.item = item;
        hasItem = true;
        notifyAll();
    }
  
    public synchronized int retrieveItem() {
        while (!hasItem) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasItem = false;
        notifyAll();
        return item;
    }
 }
  
 class ItemProducer extends Thread {
    private Storage storage;
  
    public ItemProducer(Storage storage) {
        this.storage = storage;
    }
  
    public void run() {
        for (int i = 0; i < 5; i++) {
            storage.addItem(i);
            System.out.println("Item produced: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 }
  
 class ItemConsumer extends Thread {
    private Storage storage;
  
    public ItemConsumer(Storage storage) {
        this.storage = storage;
    }
  
    public void run() {
        for (int i = 0; i < 5; i++) {
            int item = storage.retrieveItem();
            System.out.println("Item consumed: " + item);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 }
  
 public class Producer {
    public static void main(String[] args) {
        Storage storage = new Storage();
        ItemProducer producer = new ItemProducer(storage);
        ItemConsumer consumer = new ItemConsumer(storage);
  
  
  
        producer.start();
        consumer.start();
    }
 }