package Lab4;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFileToStr {
    public String[] read(String fileName) throws FileReadException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            List<String> text = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                text.addAll(Arrays.asList(line.split(" ")));
            }
            return text.toArray(new String[0]);
        } catch (NoSuchFileException e) {
            throw new FileReadException("File not found.");
        }  catch (IOException e) {
            throw new FileReadException("Error reading file.");
        }
    }
}

