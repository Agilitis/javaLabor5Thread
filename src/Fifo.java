import java.util.ArrayList;

public class Fifo {
    ArrayList<String> fifo;

    Fifo() {
        fifo = new ArrayList<>();
    }

    synchronized void put(String str) {
        fifo.add(str);
        System.out.println("produced " + str);
    }

    synchronized String get() throws InterruptedException {
        if (fifo.size() == 0) {
            Thread.sleep(Long.MAX_VALUE);
        }
        String msg = fifo.get(0);
        fifo.remove(0);
        return msg;
    }
}
