package lab_3_2;
import java.util.concurrent.Semaphore;

public class Counter {
    private int value = 0;
    private Semaphore semaphore = new Semaphore(1);

    public int getValue() {
        return value;
    }

    public void increment() {
        try {
            semaphore.acquire();
            value++;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    public void decrement() {
        try {
            semaphore.acquire();
            value--;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}