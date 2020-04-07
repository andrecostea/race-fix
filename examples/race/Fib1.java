import com.facebook.infer.annotation.*;

@ThreadSafe
public class Fib1 {

    Fib1() { super(); }

    static class BoxInteger {
        public int v;
    }

    // synchronized
    void fib (final BoxInteger ret, final int n) {
        if ( n < 2) {
            ret.v = n;
            return;
        }
        final BoxInteger X = new BoxInteger();
        final BoxInteger Y = new BoxInteger();
        Runnable block1 = new Runnable() {
                public void run() {
                    synchronized (X) {
                        fib (X, n-1);
                    }
                }
            };
        Runnable block2 = new Runnable() {
                public void run() {
                    synchronized (Y) {
                        fib (Y, n-2);
                    }
                }
            };
        Thread t1 = new Thread(block1);
        Thread t2 = new Thread(block2);

        t1.start();
        t2.start();

        // try{
        //     t1.join();
        //     t2.join();
        // }  catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // fib (X, n-1);
        // fib (Y, n-2);

        ret.v = X.v + Y.v;
    }

    public static void main (String[] args) {
        if( args.length != 1 ) {
            System.err.println("Usage: Fib <n>\n");
            System.exit(0);
        }

        final int n = java.lang.Integer.parseInt(args[0]);
        final Fib1 f = new Fib1();

        final BoxInteger Z = new BoxInteger();
        double t1 = System.nanoTime()/1e9;
        // finish {
        //     async {
        //         // Read of final variables need not be reported
                f.fib (Z, n);
        //     }
                int y = Z.v;
        // }
        double t2 = System.nanoTime()/1e9;
        System.out.println(Z.v);
        java.text.DecimalFormat df = new java.text.DecimalFormat ("#.##");
        System.out.println("time = " + df.format(t2-t1) + " sec");
    }
}
