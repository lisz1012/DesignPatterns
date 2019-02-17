package observer;

import java.util.ArrayList;
import java.util.List;

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
    private List<WakenUpListener> listeners = new ArrayList<>();

    public void addWakenUpListener(WakenUpListener l) {
        listeners.add(l);
    }

    void wakeUp(){
        WakenUpEvent e = new WakenUpEvent(System.currentTimeMillis(), "bed", this);
        listeners.forEach(x -> x.actionPerformed(e));
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

class Dad implements WakenUpListener {
    @Override
    public void actionPerformed(WakenUpEvent e) {
        System.out.println("Wake up at " + e.getLoc());
        System.out.println("Feeding " + e.getSource());
    }
}


class GrandFather implements WakenUpListener {
    @Override
    public void actionPerformed(WakenUpEvent e) {
        System.out.println("Wake up at " + e.getTime());
        System.out.println("Hugging " + e.getSource());
    }
}

public class Main {

    public static void main(String[] args) {
        WakenUpListener l1 = new Dad();
        WakenUpListener l2 = new GrandFather();
        Child c = new Child();
        c.addWakenUpListener(l1);
        c.addWakenUpListener(l2);
        new Thread(c).start();
    }
}
