import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner2 {
  private int mTemperature;

  //
  synchronized public void makeDinner() {
          boilWater();
  }

  //Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: true Pre: OwnedIf{ 0 }; loc= line 14; trace= { void Dinner2.boilWater() at line 9 }} } 
  synchronized private void boilWater() {
          mTemperature = 100; // unprotected write.
  }
}
