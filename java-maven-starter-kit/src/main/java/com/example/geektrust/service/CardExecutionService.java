package com.example.geektrust.service;

import com.example.geektrust.exception.ProcessException;
import com.example.geektrust.model.InputCommands;
import com.example.geektrust.model.Passenger;

import java.util.List;

public interface CardExecutionService {

    public String executeCommands(List<InputCommands> arguments) throws ProcessException;

    //BALANCE command execution
    public Passenger initializeBalance(List<String> tokens);

    //CHECK_IN command execution
    public void processCheckIn(List<String> tokens) throws ProcessException;

    //PRINT_SUMMARY command execution
    public String printSummary();
}
