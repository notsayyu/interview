package chapter1;

import model.User;

import java.util.*;
import java.util.Map.*;

/**
 * 已知一个HashMap<Integer, User>集合，写一个方法对该map进行排序
 */
public class HashMapTest {

    public static void main(String[] args){
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        HashMap<Integer, User> sortMap = sortHashMap(users);
        System.out.println(sortMap);
    }

    public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map){
        //首先拿到map的键值对集合
        Set<Entry<Integer, User>> entrySet = map.entrySet();
        //将set集合转为List集合，以便使用工具类的排序方法
        List<Entry<Integer, User>> list = new ArrayList<Entry<Integer, User>>(entrySet);

        Collections.synchronizedList(list);

        //使用Collections集合工具类对list进行排序，排序规则使用匿名内部类来实现
        Collections.sort(list, (o1, o2)-> o2.getValue().getAge() - o1.getValue().getAge());

        //创建一个新的有序的hashMap子类的集合
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        //将List中的数据存储在LinkedHashMap中
        list.forEach(obj -> linkedHashMap.put(obj.getKey(), obj.getValue()));
        return linkedHashMap;
    }
}
