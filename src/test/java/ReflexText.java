import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ReflexText {

    @Test
    public void optionTest() {
        String className = "com.application.v1.library.select.DeptNameSelect";
        String methodName = "getOption";
        try {
            Class classes = Class.forName(className);
            Object object = classes.newInstance();
            //获取方法
            Method method = object.getClass().getDeclaredMethod(methodName);
            //调用方法
            Map<String, Object> result = (Map<String, Object>) method.invoke(object);
//            Dumper.dump(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
