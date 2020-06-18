package threads;

/**
 * @description:
 * @author: dsy
 * @date: 2019/5/16 13:43
 */
public class WaitTest {
    /**
     * 简单协作示例
     */
    static class WaitThread extends Thread {
        private volatile boolean fire = false;

        @Override
        public void run() {
            try {
                synchronized (this) {
                    while (!fire) {
                        System.out.println("waiting");
                        wait();
                    }
                }
                System.out.println("fired");
                } catch (InterruptedException e){

                }

            }

            public synchronized void fire(){
                this.fire = true;
                notify();
            }
        }

    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        Thread.sleep(4000);
        System.out.println("fire");
        Thread.sleep(1000);
        waitThread.fire();
    }
}
