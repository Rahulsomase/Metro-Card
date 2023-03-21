package com.example.geektrust.utility;

import com.example.geektrust.exception.ProcessException;
import com.example.geektrust.model.InputCommands;

//@Author - Rahul Somase
public interface InputChecks {

    public void commandChecks(InputCommands inputCommand) throws ProcessException;
}
