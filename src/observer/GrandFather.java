package observer;

public class GrandFather implements WakenUpListener {
    @Override
    public void actionPerformed(WakenUpEvent e) {
        System.out.println("Wake up at " + e.getTime());
        System.out.println("Hugging " + e.getSource());
    }
}