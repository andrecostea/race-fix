public class Racy {
    public void foo(B b) {
        final A a = new A();
        synchronized (this) {
            b.haz(a);
            b.haha(42);
        }
    }
}

class B {
    A myA = new A();
    public synchronized void haz (A a) {
        myA = a;
    }

    protected void haha(int x){
        myA.f = x;
    }
}

class A { int f = 0; }
