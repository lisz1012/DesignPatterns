package observer;

public class Dad implements WakenUpListener {
    @Override
    public void actionPerformed(WakenUpEvent e) {
        System.out.println("Wake up at " + e.getLoc());
        System.out.println("Feeding " + e.getSource());
    }
}
