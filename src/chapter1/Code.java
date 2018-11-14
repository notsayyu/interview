package chapter1;

import model.User;

import java.io.*;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.Set;

public class Code {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        stringCode();
//        System.out.println(Clock.systemDefaultZone().millis());
//        localDateCode();
//        basicDataType();
//        serializableCode();
         hashSetCode();
    }


    /**
     * String
     */
    private static void stringCode(){
        String s1 = "helloword";
        String s2 = new String("helloword");
        System.out.println("s2 = " + s2);
        System.out.println("s2Intern = " + s2.intern());
        String s3 = "hello";
        String s4 = "word";
        String s5 = "hello" + "word";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }

    /**
     * LocalDate
     */
    private static void localDateCode(){
        LocalDate today = LocalDate.now();
        LocalDate firstDay = LocalDate.of(today.getYear(), today.getMonth(), 1);
        System.out.println("本月第一天： " + firstDay);
        LocalDate lastDay = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月最后一天： " + lastDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(today.format(formatter));
    }

    /**
     * instanceof
     */
    interface Human{

    }
    class Man implements Human{

    }
    class People extends Man{

    }
    private void instanceofCode(){
        Man man = new Man();
        People people = new People();
        System.out.println(man instanceof People);
        System.out.println(people instanceof Human);
        System.out.println(people instanceof Man);
    }

    private static void basicDataType(){
        short s1 = 1;
        s1 = (short) (s1 + 1);
        s1 += 1;//隐含了强制类型转换：相当于(short) (s1 + 1);

        Integer a = new Integer(4);
        Integer b = 3;
        int c = 3;
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(b == c);

        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);//用equals比较的是值，用==比较的是引用。
        System.out.println(f3 == f4);//整型字面量的值在-128到127之间会直接从引用常量池中取，如果不在范围内则会new

    }

    /**
     * 如何将一个java对象序列化到文件里
     */
    private static void serializableCode() throws IOException, ClassNotFoundException {
        //对象输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(new File("D://obj")));

        objectOutputStream.writeObject(new User("张三", 18));
        objectOutputStream.close();

        //对象输入流
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(new File("D://obj")));
        User user = (User) objectInputStream.readObject();

        System.out.println(user);
        objectInputStream.close();
    }

    /**
     * HashSet
     */
    private static void hashSetCode(){
        Set<User> userSet = new HashSet<>();
        User user1 = new User("zhangsan", 15);
        User user2 = new User("lisi", 16);
        User user3 = new User("wangwu", 17);
        boolean b1 = userSet.add(user1);
        boolean b2 = userSet.add(user2);
        boolean b3 = userSet.add(user3);
        System.out.println("set中一共有 " + userSet.size() + "个元素");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        user3.setAge(11);
        user3.setName("mazi");
        boolean b4 = userSet.add(user3);
        userSet.add(null);
        System.out.println("set中一共有 " + userSet.size() + "个元素");
        System.out.println(b4);

    }


}
