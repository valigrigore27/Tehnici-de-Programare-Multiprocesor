package lab_2_1;

public class DecThread extends Thread{
    SharedCounter shared;
    int local;
    int iterations;

    public DecThread(SharedCounter shared, int iterations) {
        this.shared = shared;
        this.iterations = iterations;
    }

    public void run (){
        int i = 0;
        while (i < iterations) {
            local = shared.get();
            local--;
            shared.set(local);
            i++;
        }
    }
}
