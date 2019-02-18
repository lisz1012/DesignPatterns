package observer;

import java.util.ArrayList;
import java.util.List;

public class Child implements Runnable {
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
