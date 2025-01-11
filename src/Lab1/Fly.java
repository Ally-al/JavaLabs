package Lab1;

public class Fly implements Move{
    @Override
    public void move(StringBuffer outputText) {
        outputText.append("Flying\n");
    }
}
