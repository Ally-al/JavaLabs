package Lab2;

public class MyMethods {

    private StringBuffer outputText;
    public MyMethods(StringBuffer outputText)
    {
        this.outputText = outputText;
    }

    @IntAnnotation(quantity = 1)
    public void f1(String arg) {
        outputText.append("function f1 - " + arg + '\n');
    }
    public void f2(int arg) {
        outputText.append("function f2 - " + arg + '\n');
    }
    public void f3(double arg1, double arg2) {
        double result = arg1 + arg2;
        outputText.append("function f3 - " + result + '\n');
    }
    @IntAnnotation(quantity = 4)
    protected void f4(double arg) {
        outputText.append("function f4 - " + arg + '\n');
    }
    @IntAnnotation(quantity = 5)
    protected void f5(char arg1, char arg2) {
        outputText.append("function f5 - " + arg1 + arg2 + '\n');
    }
    private void f6(char arg1) {
        outputText.append("function f6 - " + arg1 + '\n');
    }
    @IntAnnotation(quantity = 7)
    private void f7(boolean arg) {
        outputText.append("function f7 - " + arg + '\n');
    }
}
