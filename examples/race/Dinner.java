import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner {
  private int mTemperature;

    //Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 14;  trace= { void Dinner.boilWater() at line 9 }} } 
  public void makeDinner() {
          boilWater();
  }

  // Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 14; trace= { }} } 
  private void boilWater() {
          mTemperature = 100; // unprotected write.
  }
}


/**
 Specs:

 ==== Dinner.makeDinner()
 PRE:
 this = val$1: ;
 this|->{mTemperature:val$2}:
 POST 1 of 1:
 return = val$3:; this = val$1: ;
 this|->{mTemperature:100}:

 ==== Dinner.boilWater()
 PRE:
 this = val$1: ;
 this|->{mTemperature:val$2}:
 POST 1 of 1:
 return = val$3:; this = val$1: ;
 this|->{mTemperature:100}:
 */

