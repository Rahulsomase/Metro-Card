package com.example.geektrust.utility;

import com.example.geektrust.exception.ProcessException;
import com.example.geektrust.model.InputCommands;

public interface InputChecks {

    public void commandChecks(InputCommands inputCommand) throws ProcessException;
}
