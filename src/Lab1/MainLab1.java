package Lab1;

import java.util.Scanner;
import javax.swing.*;
import java.util.InputMismatchException;


public class MainLab1 {
    public static void execute(String input, JTextArea output) {

        int number = 0;
        Hero hero = new Hero();

        StringBuffer outputText = new StringBuffer();
        Scanner scanner = new Scanner(input);

        while (true) {
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    hero.setMove(new BikeRide());
                    hero.executeMove(outputText);
                    break;
                case 2:
                    hero.setMove(new Fly());
                    hero.executeMove(outputText);
                    break;
                case 3:
                    hero.setMove(new HorseRide());
                    hero.executeMove(outputText);
                    break;
                case 4:
                    hero.setMove(new Walk());
                    hero.executeMove(outputText);
                    break;
                default:
                    scanner.close();
                    outputText.append("Wrong number. End of program.");
                    output.setText(outputText.toString());
                    return;
            }
            output.setText(outputText.toString());
        }
    }
}
