package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @description:
 * @author: dsy
 * @date: 2020/6/17 19:05
 */
public class ReflectTest {
    private final  static Logger logger = Logger.getLogger("reflect.ReflectTest");

    public static void main(String[] args) {
        ReflectTest.reflectNewInstance();
        reflectPrivateConstructor();
        reflectPrivateFiled();
        reflectPublicMethod();
        reflectPrivateMethod();
    }

    //创建对象
    public static void reflectNewInstance() {
        try {
            Class classUser = Class.forName("reflect.User");
            Object objectUser = classUser.newInstance();
            User user = (User) objectUser;
            user.setName("小明");
            user.setAge(18);
            logger.info("reflectNewInstance user = " + user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //反射私有的构造方法
    public static void reflectPrivateConstructor(){
        try {
            Class classUser = Class.forName("reflect.User");
            Constructor declaredConstructorUser = classUser.getDeclaredConstructor(String.class, int.class);
//            declaredConstructorUser.setAccessible(true);
            Object objectUser = declaredConstructorUser.newInstance("小明",18);
            User user = (User) objectUser;
            logger.info("reflectPrivateConstructor user = " + user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //反射私有属性
    public static void reflectPrivateFiled(){
        try {
            Class classUser = Class.forName("reflect.User");
            Constructor declaredConstructorUser = classUser.getDeclaredConstructor(String.class, int.class);
//            declaredConstructorUser.setAccessible(true);
            Object objectUser = declaredConstructorUser.newInstance("小明",18);
            Field fieldName = classUser.getDeclaredField("name");
            fieldName.setAccessible(true);
            String name = (String) fieldName.get(objectUser);
            logger.info("reflectPrivateFiled name = " + name);

            logger.info("reflectPrivateFiled fieldName = " + fieldName.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //反射私有方法
    public static void reflectPublicMethod(){
        try {
            Class classUser = Class.forName("reflect.User");
            Method method = classUser.getMethod("method1");
            method.setAccessible(true);
            Object objectUser = classUser.newInstance();
            method.invoke(objectUser);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //反射私有方法
    public static void reflectPrivateMethod(){
        try {
            Class classUser = Class.forName("reflect.User");
            Method method = classUser.getDeclaredMethod("method2", int.class);
            method.setAccessible(true);
            Object objectUser = classUser.newInstance();
            int result = (int) method.invoke(objectUser, 2);
            logger.info("reflectPrivateMethod result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
