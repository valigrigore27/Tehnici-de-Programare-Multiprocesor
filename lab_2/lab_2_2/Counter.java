package lab_2_2;

public class Counter {
    private int value = 0;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void increment() {
        value++;
    }

    public synchronized void decrement() {
        value--;
    }
}
