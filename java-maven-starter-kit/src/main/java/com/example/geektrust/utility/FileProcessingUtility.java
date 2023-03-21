package com.example.geektrust.utility;

import com.example.geektrust.exception.ProcessException;
import com.example.geektrust.model.InputCommands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessingUtility {
    private String filePath;

    public FileProcessingUtility() {}

    public FileProcessingUtility(String filePath) {
        this.filePath = filePath;
    }

    //Collect input commands as a list
    public List<InputCommands> getCommandsFromFile() throws ProcessException {
        try (Stream<String> lines = Files.lines(Paths.get(this.filePath))) {
            return lines.filter(line -> !isEmptyOrComment(line)).map(line -> parseInput(line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new ProcessException("Some error occurred while processing input file");
        }
    }

    //Check if command is empty or is a comment
    private boolean isEmptyOrComment(String line) {
        return line.trim().isEmpty() || line.trim().startsWith("#");
    }

    //initialize input commands
    public InputCommands parseInput(String str) {
        try {
            String[] commandWithArguments = str.split(" ");
            List<String> tokens = Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
            InputCommands input = new InputCommands(commandWithArguments[0], tokens);
            return input;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Invalid Command Supplied: " + str);
        }
    }
}
