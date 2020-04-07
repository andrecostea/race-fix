import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner {
  private int mTemperature;

  // Accesses { Loc: line 8 Access: Write to this->mTemperature Thread: AnyThread Lock: false Pre: Owned({ 0 }) }
  public void makeDinner() {
          boilWater();
  }


 // Accesses { Loc: line 12 Access: Write to this->mTemperature Thread: AnyThread Lock: false Pre: Owned({ 0 }) }
  private void boilWater() {
          mTemperature = 100; // unprotected write.
  }
}
