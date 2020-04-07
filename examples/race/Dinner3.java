import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner3 {
  private int mTemperature;

  /** Accesses { Loc: line 8 Access: Write to this->mTemperature Thread: AnyThread Lock: true Pre: Owned({ 0 }) } */
  public void makeDinner() {
          boilWater();
  }

  /** Accesses { Loc: line 13 Access: Write to this->mTemperature Thread: AnyThread Lock: true Pre: Owned({ 0 }) }  */
  private void boilWater() {
      synchronized(this){
          mTemperature = 100; // unprotected write.
      }
  }
}
