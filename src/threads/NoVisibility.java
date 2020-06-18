package threads;

/**
 * @description: 可见性
 * @author: dsy
 * @date: 2020/3/23 13:05
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            while (ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args){
        new ReaderThread().start();
        number = 4;
        ready = true;
    }
}
