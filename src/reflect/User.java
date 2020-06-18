package reflect;

import java.util.logging.Logger;

/**
 * @description:
 * @author: dsy
 * @date: 2020/6/17 18:59
 */
public class User {
    Logger logger = Logger.getLogger("reflect.User");

    private String name;

    private int age;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void method1(){
        logger.info("i am method1 !");
    }

    private int method2(int age){
        logger.info("i am method2 !");
        return age * age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
