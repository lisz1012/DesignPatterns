package observer;

class Child {

    private boolean wakenUp = false;

    public boolean isWakenUp() {
        return wakenUp;
    }

    void wakeUp(){
        wakenUp = true;
    }
}

class Dad implements Runnable {
    Child c;
    public Dad (Child c) {
        this.c = c;
    }
    @Override
    public void run() {
        while (!c.isWakenUp()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        feed(c);
    }

    private void feed(Child c) {
        System.out.println("Feeding " + c);
    }
}

public class Main {

    public static void main(String[] args) {
        Child c = new Child();
        new Thread(new Dad(c)).start();
    }
}
