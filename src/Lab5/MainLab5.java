package Lab5;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class MainLab5 {
    public static void execute(JTextArea output) {
        StringBuffer outputText = new StringBuffer();
        MyMethods5 methods = new MyMethods5();

        List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        double average = methods.getAverage(list1);
        outputText.append("1: " + average + '\n');

        List<String> list2 = Arrays.asList("one", "two", "three");
        methods.toUpReg(list2);
        outputText.append("2: " + list2 + '\n');

        List<Double> list3 = Arrays.asList(0.0, 4.0, 4.0, 3.3);
        List<Double> squareOfUnique = methods.getSquareOfUnique(list3);
        outputText.append("3: " + squareOfUnique + '\n');

        Collection<String> coll4 = Arrays.asList("one", "two", "ten", "online", "os", "oc", "h");
        Collection<String> sortedStrs = methods.sortStrings(coll4, 'o');
        outputText.append("4: " + sortedStrs + '\n');

        try {
            Collection<Integer> coll51 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
            int last = methods.getLastElement(coll51);
            outputText.append("5: " + last + '\n');

            Collection<Integer> coll52 = Arrays.asList();
            int last2 = methods.getLastElement(coll52);
            outputText.append("5: " + last2 + '\n');
        } catch (IllegalArgumentException e) {
            outputText.append("5: Коллекция пустая" + '\n');
            output.setText(outputText.toString());
        }

        int[] arr61 = {1, 2, 3, 4, 5, 10};
        int sum61 = methods.getEvenSum(arr61);
        outputText.append("6: " + sum61 + '\n');

        int[] arr62 = {1, 3, 7};
        int sum62 = methods.getEvenSum(arr62);
        outputText.append("6: " + sum62 + '\n');

        try {
            List<String> list71 = Arrays.asList("cup", "table", "you");
            Map<Character, String> map71 = methods.strsToMap(list71);
            outputText.append("7: " + map71 + '\n');

            List<String> list72 = Arrays.asList("cup", "table", "two");
            Map<Character, String> map72 = methods.strsToMap(list72);
            outputText.append("7: " + map72 + '\n');
        } catch (IllegalStateException e) {
            outputText.append("7: Повтор ключа" + '\n');
            output.setText(outputText.toString());
        }

        output.setText(outputText.toString());
    }
}
