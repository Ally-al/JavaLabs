package Lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;

public class ReadMap {
    public HashMap<String, String> read(String fileName) throws InvalidFileFormatException, FileReadException {
        HashMap<String, String> map = new HashMap<String, String>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\s{1}[|]\s{1}");
                if (parts.length != 2) {
                    throw new InvalidFileFormatException("Invalid file format.");
                }
                map.put(parts[0].toLowerCase(), parts[1]);
            }
            reader.close();
        } catch (NoSuchFileException e) {
            throw new FileReadException("File not found.");
        }  catch (IOException e) {
            throw new FileReadException("Error reading file.");
        }
        return map;
    }
}

