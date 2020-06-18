package designpatterns;

/**
 * @description:
 * @author: dsy
 * @date: 2019/7/19 13:36
 */
public class Singleton {

    //ThreadLocal 线程局部变量
    private static ThreadLocal<Singleton> threadLocal = new ThreadLocal<Singleton>();
    private static Singleton singleton = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(threadLocal.get() == null){
            createInstance();
        }
        return singleton;
    }

    public static void createInstance(){
            synchronized (Singleton.class){
                //只需在第一次创建实例时才同步
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
            threadLocal.set(singleton);
        }
}
