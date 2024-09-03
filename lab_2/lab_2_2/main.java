package lab_2_2;

public class main {
        public static float run(int n, int m){

            Counter counter = new Counter();
            Thread[] type1Threads = new Thread[n];
            Thread[] type2Threads = new Thread[m];

            long startTime = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                type1Threads[i] = new Type1Thread(counter);
                type1Threads[i].start();
            }

            for (int i = 0; i < m; i++) {
                type2Threads[i] = new Type2Thread(counter);
                type2Threads[i].start();
            }

            for (int i = 0; i < n; i++) {
                try {
                    type1Threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < m; i++) {
                try {
                    type2Threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.currentTimeMillis();

            System.out.println("Valoarea contorului: " + counter.getValue());
            float time = endTime - startTime;
            return time;

        }
        public static void main(String[] args) {
            int n = 1;
            int m = 1;

            for(int i=1; i<=4; i*=2){
                System.out.println("n: " + n*i + " m: " + m*i);
               float time = run(n*i, m*i);
                System.out.println("Durata executiei: " + time + " ms");
            }
        }
}
