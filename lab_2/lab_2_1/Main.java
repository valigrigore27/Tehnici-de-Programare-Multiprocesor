package lab_2_1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter myShared = new SharedCounter();

        int n = 4;
        int m = 4;
        int iterations = 100000;

        IncThread[] inc = new IncThread[n];
        DecThread[] dec = new DecThread[m];

        for(int i = 0; i < n; i++) {
            inc[i] = new IncThread(myShared, iterations);
        }

        for(int i = 0; i < m; i++) {
            dec[i] = new DecThread(myShared, iterations);
        }

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++) {
            inc[i].start();
        }
        for(int i = 0; i < m; i++) {
            dec[i].start();
        }

        for(int i = 0; i < n; i++) {
            inc[i].join();
        }

        for(int i = 0; i < m; i++) {
            dec[i].join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Shared count is: " +  myShared.get());
        System.out.println("Time elapsed: " + (endTime - startTime) + " milliseconds");

    }
}
