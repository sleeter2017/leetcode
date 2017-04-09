import java.util.concurrent.Semaphore;

public class ThreadAndSemaphore {

    public static Semaphore semaphore = new Semaphore(4); // 4 resources can share.  If its only 1, its call mutex


    static class ATMThreadAndSemaphore implements Runnable {
        public int count = 0;

        @Override
        public void run() {
            System.out.println("Runnable Thread starting");

            try {
                semaphore.acquire();
                System.out.println("Aquired semaphore");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                while (count < 5) {
                    Thread.sleep(500);  // 500 milli sec

                    System.out.println("Count = " + count);
                    count++;

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Runnable Thread interrupted");
            }
            System.out.println("Thread terminating. Also releasing semaphore");
            semaphore.release();
        }
    }


    public static void main(String[] args) {
        ATMThreadAndSemaphore instance = new ATMThreadAndSemaphore();
        Thread threadA = new Thread(instance);
        Thread threadB = new Thread(new ATMThreadAndSemaphore());

        threadA.start();
        threadB.start();

        threadA.setName("threadA");
        threadB.setName("threadB");

        // waits until above thread counts to 5
        while(instance.count != 5) {
            try {
//                System.out.println("Sleeping for .25 sec");
                Thread.sleep(250);
            }catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
