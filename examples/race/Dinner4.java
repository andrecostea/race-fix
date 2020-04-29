import com.facebook.infer.annotation.*;

@ThreadSafe
public class Dinner4 {
    private int mTemperature;
    private int mTemperature0;

  public void makeDinner() {
          foo();//boilWater();
  }

  private void boilWater() {
      synchronized(this) {
          mTemperature  = 100; // unprotected write.
          mTemperature0 = 100; }
  }

  private void foo(){
        boilWater();
  }
}


/**

 ==== Dinner.makeDinner()

 Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 12;  trace= { void Dinner4.foo() at line 8,  void Dinner4.boilWater() at line 16 }} } 

 PRE:
 this = val$1: ;
 this|->{mTemperature:val$2}:
 POST 1 of 1:
 return = val$3:; this = val$1: ;
 this|->{mTemperature:100}:


 ==== Dinner.boilWater()

 // Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 12; trace= { }} }
 
 PRE:
 this = val$1: ;
 this|->{mTemperature:val$2}:
 POST 1 of 1:
 return = val$3:; this = val$1: ;
 this|->{mTemperature:100}:


 ==== Dinner.foo()

 Accesses { {elem= Access: Write to this->mTemperature Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 12;  trace= { void Dinner4.boilWater() at line 16 }} } 

*/



