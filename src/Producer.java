public class Producer extends Thread {
    Fifo fifo;
    String msg;
    Producer(Fifo fifo, String msg) {
        this.fifo = fifo;
        this.msg = msg;
    }

    public void run() {
        go();
    }

    void go() {
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fifo.put(msg + " " + counter + " " + System.currentTimeMillis() % 100000);
            counter++;
        }
    }
}
