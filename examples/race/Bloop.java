class Bloop {
    public int f = 1;
}

class Burble {

    public void meps(Bloop b) {
        synchronized (this) {
            System.out.println(b.f);
        }
    }

    public void reps(Bloop b) {
        b.f = 42;
    }

    public void beps(Bloop b) {
        b = new Bloop();
        b.f = 239;
    }
}
