import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner1 {
  private int mTemperature;

  public void makeDinner() {
      synchronized(this){
          boilWater();
      }
  }

  private void boilWater() {
      synchronized(this){
          mTemperature = 100; // unprotected write.
      }
  }
}
