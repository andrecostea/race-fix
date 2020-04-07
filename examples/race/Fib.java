import hj.runtime.wst.racedet.*;

public class Fib {

    Fib() { super(); }

    static class BoxInteger {
        public int v;
    }

    void fib (final BoxInteger ret, final int n) {
        if ( n < 2) {
            ret.v = n;
            return;
        }
        final BoxInteger X = new BoxInteger();
        final BoxInteger Y = new BoxInteger();
            async fib (X, n-1);
            async fib (Y, n-2);
        ret.v = X.v + Y.v;
    }

    public static void main (String[] args) {
        if( args.length != 1 ) {
            System.err.println("Usage: Fib <n>\n");
            System.exit(0);
        }

        final int n = java.lang.Integer.parseInt(args[0]);
        final Fib f = new Fib();

        final BoxInteger Z = new BoxInteger();
        double t1 = System.nanoTime()/1e9;
        finish {
            async {
                // Read of final variables need not be reported
                f.fib (Z, n);
            }
            //int y = Z.v;
        }
        double t2 = System.nanoTime()/1e9;
        System.out.println(Z.v);
        java.text.DecimalFormat df = new java.text.DecimalFormat ("#.##");
        System.out.println("time = " + df.format(t2-t1) + " sec");
    }
}
