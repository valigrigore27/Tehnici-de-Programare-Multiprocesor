package lab_2_1;

public class SharedCounter {
    int count = 0;
    public synchronized int get() {
        return count;
    }
    public synchronized void set(int count) {
        this.count = count;
    }
}
