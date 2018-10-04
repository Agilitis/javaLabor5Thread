public class Consumer extends Thread {
    Fifo fifo;
    String str;
    int number;

    Consumer(Fifo fifo, String str, int number) {
        this.fifo = fifo;
        this.str = str;
        this.number = number;
    }

    public void run() {
        while (true) {
            String messageFromFifo = "No message!!";
            try {
                messageFromFifo = fifo.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consumed " + str + " " + messageFromFifo + " " + System.currentTimeMillis() % 100000);
            try {
                Thread.sleep(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
