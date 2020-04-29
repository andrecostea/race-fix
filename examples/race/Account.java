import com.facebook.infer.annotation.*;


@ThreadSafe
public class Account {

    int mBalance = 0;

    public void deposit(int amount) {
        if (amount > 0) {
            mBalance += amount;
        }
    }

    public int withdraw(int amount){
        if (amount >= 0 && mBalance - amount >= 0) {
            mBalance -= amount;
            return mBalance;
        } else {
            return 0;
        }
    }
}


/**
  A solution to the threading problem here is to make both methods synchronized
  to wrap both read and write accesses, or to use an AtomicInteger for mBalance
  rather than an ordinary int.


  ==== void Account.deposit(int)
  Accesses {
  {elem= Access: Read of this->mBalance Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 11; trace= { }},
  {elem= Access: Write to this->mBalance Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 11; trace= { }} }


  ==== int Account.withdraw(int)
  Accesses {
  {elem= Access: Read of this->mBalance Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 16; trace= { }},
  {elem= Access: Write to this->mBalance Thread: AnyThread Lock: false Pre: OwnedIf{ 0 }; loc= line 17; trace= { }} } 



*/
