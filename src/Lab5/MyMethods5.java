package Lab5;

import java.util.*;
import java.util.stream.Collectors;


public class MyMethods5 {
    public double getAverage(List<Integer> list) {
        return list.stream().mapToInt(i -> i).average().orElse(0);
    }
    public void toUpReg(List<String> list) {
        list.stream().forEach(s -> list.set(list.indexOf(s), "_new_" + s.toUpperCase()));
    }
    public List<Double> getSquareOfUnique(List<Double> list) {
        return list.stream().filter(i -> list.stream().filter(j -> j.equals(i)).count() == 1)
                .distinct().map(i -> i * i)
                .collect(Collectors.toList());
    }
    public Collection<String> sortStrings(Collection<String > coll, char startLetter) {
        return coll.stream().filter(s -> s.charAt(0) == startLetter).collect(Collectors.toCollection(TreeSet::new));
    }
    public <T> T getLastElement(Collection<T> coll) {
        return coll.stream().reduce((first, second) -> second).orElseThrow(IllegalArgumentException::new);
    }
    public int getEvenSum(int[] arr) {
        return Arrays.stream(arr).filter(i -> i % 2 == 0).sum();
    }

    public Map<Character, String> strsToMap(List<String> list) {
        return list.stream().collect(Collectors.toMap(s -> s.charAt(0), s -> s.substring(1)));
    }
}
