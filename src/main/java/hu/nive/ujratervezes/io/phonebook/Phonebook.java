package hu.nive.ujratervezes.io.phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        try{
            Files.write(Paths.get(output), contacts.entrySet()
                    .stream()
                    .map(stringStringEntry -> String.format("%s: %s", stringStringEntry.getKey(), stringStringEntry.getValue()))
                    .collect(Collectors.joining(System.lineSeparator())).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}