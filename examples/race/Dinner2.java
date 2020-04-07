import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner2 {
  private int mTemperature;

  synchronized public void makeDinner() {
          boilWater();
  }

  synchronized private void boilWater() {
          mTemperature = 100; // unprotected write.
  }
}
