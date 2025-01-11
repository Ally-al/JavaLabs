package Lab1;

public class Hero {
    private Move move;

    public void setMove(Move move) {
        this.move = move;
    }

    public void executeMove(StringBuffer outputText) {
        move.move(outputText);
    }
}

