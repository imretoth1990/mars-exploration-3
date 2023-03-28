package com.codecool.marsexploration.controller.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.controller.fileoperator.FileWriter;

import java.util.ArrayList;
import java.util.List;

public class Log implements Phase{
    List<String> stringList = new ArrayList<>();

    @Override
    public void perform(Context context) {
        String fileName = context.getLogFilePath();
        String logMessage;
        if(context.getExplorationOutcome().isEmpty()) {
            logMessage = "STEP " + context.getStepNumber()+"; " + "EVENT position; UNIT " + context.getRover().getId() + "; " + "POSITION " + context.getRover().getCurrentPosition()+"\n";
            stringList.add( logMessage );
        } else {
            logMessage = "STEP " + context.getStepNumber()+"; " + "EVENT outcome; UNIT " + context.getRover().getId() + "; " + "OUTCOME " + context.getExplorationOutcome()+"\n";
            stringList.add( logMessage );
            FileWriter fileWriter = new FileWriter( stringList );
            fileWriter.writeLogFile( fileName );
        }
    }
}
