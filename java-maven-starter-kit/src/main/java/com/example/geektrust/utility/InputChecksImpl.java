package com.example.geektrust.utility;

import com.example.geektrust.exception.ProcessException;
import com.example.geektrust.model.InputCommands;

import java.util.List;


//@Author - Rahul Somase
public class InputChecksImpl implements InputChecks {

    @Override
    public void commandChecks(InputCommands inputCommand) throws ProcessException {
        String command=inputCommand.getCommand();
        if(command.equals("BALANCE")) {
            commandBalanceCheck(inputCommand.getToken());
        }
        else if(command.equals("CHECK_IN")) {
            commandCheckInCheck(inputCommand.getToken());
        }
        else if(command.equals("PRINT_SUMMARY")) {
            commandPrintSummaryCheck(inputCommand.getToken());
        }
        else {
            throw new ProcessException("Invalid Input Commands, please check the input command.");
        }
    }

    public void commandBalanceCheck(List<String> tokens) throws ProcessException {
        if(tokens.size()!=2) {
            throw new ProcessException("Invalid Number of Arguments, Please validate input.");
        }
        Integer balance = Integer.parseInt(tokens.get(1));
        if(balance<0) {
            throw new ProcessException("MetroCard Balance should be non negative, Please validate input.");
        }
    }
    public void commandCheckInCheck(List<String> tokens) throws ProcessException {
        if(tokens.size()!=3) {
            throw new ProcessException("Invalid Number of Arguments, Please validate input.");
        }
        String passengerType=tokens.get(1);
        if(!passengerType.equals("ADULT") && !passengerType.equals("SENIOR_CITIZEN") && !passengerType.equals("KID")) {
            throw new ProcessException("Invalid Passenger Type, Please validate input.");
        }
        String fromStation=tokens.get(2);
        if(!fromStation.equals("AIRPORT") && !fromStation.equals("CENTRAL")) {
            throw new ProcessException("Invalid Station, Metrocard Available Stations are : 1)AIRPORT  2)CENTRAL.");
        }
    }
    public void commandPrintSummaryCheck(List<String> tokens) throws ProcessException {
        if(tokens.size()!=0) {
            throw new ProcessException("Invalid Number of Arguments, Please validate input.");
        }
    }
}
