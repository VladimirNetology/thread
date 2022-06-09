import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("My Group");
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(group, new MyThread(), "myThread #" + (i + 1));
            thread.start();
        }
        Thread.sleep(15000);
        group.interrupt();

    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Started name: " + Thread.currentThread().getName());
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3000));
                System.out.println("Working name: " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
        }
        System.out.println("Finished name: " + Thread.currentThread().getName());
    }
}
