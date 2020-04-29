import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner1 {
  private int mTemperature;

    //Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: true Pre: OwnedIf{ 0 }; loc= line 17; trace= { void Dinner1.boilWater() at line 10 }} } 
  public void makeDinner() {
      synchronized(this){
          boilWater();
      }
  }

  // Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: true Pre: OwnedIf{ 0 }; loc= line 17; trace= { }} } 
  private void boilWater() {
      synchronized(this){
          mTemperature = 100; // unprotected write.
      }
  }
}
