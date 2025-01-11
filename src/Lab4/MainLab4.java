package Lab4;

import java.util.*;
import javax.swing.*;
public class MainLab4 {
    public static void execute(JTextArea output) {
        StringBuffer outputText = new StringBuffer();
        try {
            ReadMap readMap = new ReadMap();
            HashMap<String, String> map = readMap.read("dict.txt");

            ReadFileToStr readFileToStr = new ReadFileToStr();
            String[] text = readFileToStr.read("text.txt");
            outputText.append(String.join(" ", text) + '\n' + '\n');


            Translator translator = new Translator();
            translator.translate(map, text, outputText);
            output.setText(outputText.toString());

        } catch (InvalidFileFormatException | FileReadException e) {
            outputText.append(e.getMessage());
            output.setText(outputText.toString());
        }
    }
}
