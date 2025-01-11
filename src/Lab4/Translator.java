package Lab4;

import java.util.HashMap;

public class Translator {
    public void translate (HashMap<String, String> map, String[] text, StringBuffer outputText) {
        String translation = "";
        for (int i = 0; i < text.length; i++) {
            String word = text[i].toLowerCase();

            boolean isPoint = false;
            if (word.charAt(word.length() - 1) == '.') {
                word = word.substring(0, word.length() - 1);
                isPoint = true;
            }

            String translatedWord = map.getOrDefault(word, word);
            if (translatedWord.equals(word)) {
                String phraseKey = word;
                for (int j = i + 1; j < text.length; j++) {
                    phraseKey += ' ' + text[j].toLowerCase();
                    if (map.containsKey(phraseKey)) {
                        translatedWord = map.get(phraseKey);
                        i = j;
                        break;
                    }
                }
            }
            if (isPoint) {
                translatedWord += ".\n";
            }
            translation += translatedWord;
            if (translatedWord.charAt(translatedWord.length() - 1) != '\n') {
                translation += ' ';
            }
        }
        outputText.append(translation);
    }
}

