import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner {
  private int mTemperature;

  public void makeDinner() {
    boilWater();
  }

  private void boilWater() {
    mTemperature = 100; // unprotected write.
  }
}
