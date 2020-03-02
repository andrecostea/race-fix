package thread;

public class DeadLockTest {

    // Resource
    private class Resource {
    }

    public static void main(String[] args) {
        DeadLockTest test = new DeadLockTest();

        final Resource A = test.new Resource();
        final Resource B = test.new Resource();

        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (A) {
                    System.out.println("sending 1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // has c1 but needs c2
                    synchronized (B) {
                        System.out.println("receiving 2");
                    }
                }
            }
        };

        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (B) {
                    System.out.println("sending 2");
                    // has c2 but needs c1
                    synchronized (A) {
                        System.out.println("receiving 1");
                    }
                }
            }
        };

        new Thread(block1).start();
        new Thread(block2).start();
    }

}
