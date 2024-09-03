package lab_2_2;

public class Type1Thread extends Thread{
    private Counter counter;

    public Type1Thread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            int localValue;
            synchronized (counter) {
                localValue = counter.getValue();
                counter.increment();
            }
        }
    }
}
