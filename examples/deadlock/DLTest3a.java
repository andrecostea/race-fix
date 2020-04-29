
public class DLTest3a {

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
           {
           events     = { LockAcquire(this.A), LockAcquire(this.B) };
           guard_map  = { };
           lock_state = { this.A -> LockAcquire(this.A) };
           order      = { {first= this.A; eventually= LockAcquire(this.B)} }; ui= }

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
           {
           events     = { LockAcquire(this.A), LockAcquire(this.B) };
           guard_map  = { };
           lock_state = { this.B -> LockAcquire(this.B) };
           order      = { {first= this.B; eventually= LockAcquire(this.A)} };
           ui         = 
           }
        */
    }
}
