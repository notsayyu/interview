package threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: dsy
 * @date: 2019/5/27 16:30
 */
public class ConcurrentHashMapIteratorDemo {
    public static void test(){
        final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("a", "abstract");
        map.put("b", "basic");
        Thread t1 = new Thread(){
            @Override
            public void run(){
                for (Map.Entry<String, String> entry : map.entrySet()){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }
                    System.out.println(entry.getKey() + "," + entry.getValue());
                }
            }
        };
        t1.start();
//        try {
//            Thread.sleep(10);
//        }catch (InterruptedException e){
//
//        }
        map.put("a", "call");

    }
    public static void main(String[] args){
        test();
    }
}
