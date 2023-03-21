package com.example.geektrust;

import com.example.geektrust.exception.ProcessException;
import com.example.geektrust.model.InputCommands;
import com.example.geektrust.service.CardExecutionService;
import com.example.geektrust.service.CardExecutionServiceImpl;
import com.example.geektrust.utility.FileProcessingUtility;

import java.util.Collections;
import java.util.List;


//@Author - Rahul Somase
public class Main {
    public static void main(String[] args) {
        /*
        Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
        */
            try {
                if (args.length != 1) {
                    throw new ProcessException("Input file not supplied. Please provide the input file");
                }
                String filePath = args[0];
                processMetroCard(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        public static String processMetroCard(String filePath) throws ProcessException {
           FileProcessingUtility reader = new FileProcessingUtility(filePath);
            List<InputCommands> commands = reader.getCommandsFromFile();
            CardExecutionService cardService=new CardExecutionServiceImpl();
            String output=cardService.executeCommands(commands);
            return output;
        }
    }
