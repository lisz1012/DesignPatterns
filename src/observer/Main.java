package observer;

class Child implements Runnable {
    private Dad d;

    private boolean wakenUp = false;

    public Child(Dad d) {
        this.d = d;
    }

    public boolean isWakenUp() {
        return wakenUp;
    }

    void wakeUp(){
        wakenUp = true;
        d.feed(this);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wakeUp();
    }
}

class Dad {
    public void feed(Child c) {
        System.out.println("Feeding " + c);
    }
}

public class Main {

    public static void main(String[] args) {
        Dad d = new Dad();
        Child c = new Child(d);
        new Thread(c).start();
    }
}
