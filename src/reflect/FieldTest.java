package reflect;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: dsy
 * @date: 2019/6/17 18:51
 */
public class FieldTest {

    static class FieldA{
        private String name;
    }
    public static <T> T getInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        T obj = cls.newInstance();
        Field[] fields = cls.getFields();
        for (Field field : fields){
            Class<?> fieldCls = field.getType();
            field.set(obj, getInstance(fieldCls));
        }
        return null;
    }
}
