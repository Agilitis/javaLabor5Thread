public class Application {

    public static void main(String[] args) {
       Fifo myfifo = new Fifo();
       Producer prod1 = new Producer(myfifo,"elso");
       prod1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       Consumer cons = new Consumer(myfifo,"consume!", 2000);
       cons.start();
    }
}
