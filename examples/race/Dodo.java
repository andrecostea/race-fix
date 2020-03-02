// @ThreadSafe
public class Dodo {
 private Dodo dee;

 public void zap(Dodo d) {
   synchronized (this) {
       System.out.println(d.dee);
   }
 }

 public void zup(Dodo d) {
     d.dee = new Dodo();
 }

}
