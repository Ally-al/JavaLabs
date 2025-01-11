package Lab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.*;

public class MainLab2 {
    public static void execute(JTextArea output) {

        StringBuffer outputText = new StringBuffer();
        MyMethods myClass = new MyMethods(outputText);
        Method[] methods =  myClass.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(IntAnnotation.class)) {
                int value = method.getAnnotation(IntAnnotation.class).quantity();
                method.setAccessible(true);
                for (int i = 0; i < value; i++) {
                    try {
                        String name = method.getName();
                        switch (name) {
                            case "f1":
                                method.invoke(myClass,"str1");
                                break;
                            case "f2":
                                method.invoke(myClass,222);
                                break;
                            case "f3":
                                method.invoke(myClass,1.4, 1.6);
                                break;
                            case "f4":
                                method.invoke(myClass,4.4);
                                break;
                            case "f5":
                                method.invoke(myClass,'q', 'w');
                                break;
                            case "f6":
                                method.invoke(myClass,'q');
                                break;
                            case "f7":
                                method.invoke(myClass,true);
                                break;
                            default:
                                return;
                        }
                        output.setText(outputText.toString());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                outputText.append('\n');
            }
        }
    }
}









