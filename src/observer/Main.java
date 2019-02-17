package observer;

class WakenUpEvent {
    private long time;
    private String loc;
    private Child source;

    public WakenUpEvent(long time, String loc, Child source) {
        this.time = time;
        this.loc = loc;
        this.source = source;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Child getSource() {
        return source;
    }

    public void setSource(Child source) {
        this.source = source;
    }
}

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
        d.actionPerformed(new WakenUpEvent(System.currentTimeMillis(), "bed", this));
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
    public void actionPerformed(WakenUpEvent e) {
        System.out.println("Wake up at " + e.getLoc());
        System.out.println("Feeding " + e.getSource());
    }
}

public class Main {

    public static void main(String[] args) {
        Dad d = new Dad();
        Child c = new Child(d);
        new Thread(c).start();
    }
}
