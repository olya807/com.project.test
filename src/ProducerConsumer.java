import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Thread.sleep;

class ProducerConsumer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                int LIMIT = 10;
                while (buffer.size() == LIMIT) {
                    lock.wait();
                }
                buffer.add(value);
                System.out.println("Produced: " + value);
                value++;
                lock.notify();
            }
            Thread.sleep(100);
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (buffer.isEmpty()) {
                    lock.wait();
                }
                int value = buffer.poll();
                System.out.println("Consumed: " + value);
                lock.notify();
            }
            sleep(100);
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}