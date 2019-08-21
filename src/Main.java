import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer tc = new TextContainer();
        Class<?> cl = tc.getClass();

        if (!cl.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Error");
            return;
        }

        SaveTo saveTo = cl.getAnnotation(SaveTo.class);
        String path = saveTo.path();
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            try {
                if (method.isAnnotationPresent(Saver.class)) {
                    method.invoke(tc, path);
                    break;
                } else {
                    System.out.println("Error");
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
