
public class DeadLockTest2 {

    // Resource
    private class Resource {
    }

    public static void main(String[] args) {
        DeadLockTest2 test = new DeadLockTest2();

        final Resource A = test.new Resource();
        final Resource B = test.new Resource();

        Runnable block1 = new Runnable() {
                public void run() {
                    synchronized(A) {
                        System.out.println("in block1");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                        synchronized(B) {
                            // do something with both resources
                        }
                    }
                }
            };
        Runnable block2 = new Runnable() {
                public void run() {
                    synchronized(B) {
                        synchronized(A) {
                            // do something with both resources
                        }
                    }
                }
            };

        new Thread(block1).start();
        new Thread(block2).start();
    }
}
