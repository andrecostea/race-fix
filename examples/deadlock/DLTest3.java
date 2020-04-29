

public class DLTest3 {

    // Resource
    private class Resource {
        int i = 0;
    }

    Resource A = this.new Resource();
    Resource B = this.new Resource();

    public void lockAthanB(){
        /**
           PRE:
             this = val$1: ;
             val$3|->{}:; val$2|->{}:; this|->{DLTest3.A:val$2, DLTest3.B:val$3}:
           POST 1 of 1:
             return = val$4:; this = val$1: ;
             val$3|->{}:; val$2|->{}:; this|->{DLTest3.A:val$2, DLTest3.B:val$3}:
         */
        /**
           Starvation:
           { thread            = UnknownThread;
             return_attributes = Nothing;
             critical_pairs    = { {elem= {acquisitions= { }; event= LockAcquire(P<0>{(this:DLTest3*)->A})}; loc= line 31; trace= { }},
                                   {elem= {acquisitions= { P<0>{(this:DLTest3*)->A} }; event= LockAcquire(P<0>{(this:DLTest3*)->B})}; loc= line 32; trace= { }} };
             scheduled_work    = { };
             attributes        = { }}
          */
        synchronized(A) {
            synchronized(B) {
                // do something with both resources
            }
        }
    }

    public void lockBthanA(){
        /**
           PRE:
             this = val$1: ;
             val$3|->{}:; val$2|->{}:; this|->{DLTest3.A:val$2, DLTest3.B:val$3}:
           POST 1 of 1:
             return = val$4:; this = val$1: ;
             val$3|->{}:; val$2|->{}:; this|->{DLTest3.A:val$2, DLTest3.B:val$3}:
        */
        synchronized(B) {
            synchronized(A) {
                // do something with both resources
            }
        }
        /**
           Starvation:
           { thread            = UnknownThread;
             return_attributes = Nothing;
             critical_pairs    = { {elem= {acquisitions= { }; event= LockAcquire(P<0>{(this:DLTest3*)->B})}; loc= line 47; trace= { }},
                                   {elem= {acquisitions= { P<0>{(this:DLTest3*)->B} }; event= LockAcquire(P<0>{(this:DLTest3*)->A})}; loc= line 48; trace= { }} };
             scheduled_work    = { };
             attributes        = { }}
        */
    }
}
