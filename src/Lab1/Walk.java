package Lab1;

public class Walk implements Move{
    @Override
    public void move(StringBuffer outputText) {
        outputText.append("Walking\n");
    }
}