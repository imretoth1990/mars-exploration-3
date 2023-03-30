package com.codecool.marsexploration.controller.phase;

import com.codecool.marsexploration.controller.fileoperator.FileWriter;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.ArrayList;
import java.util.List;

public class Log implements Phase {
    List<String> stringList = new ArrayList<>();

    @Override
    public void perform(Context context) {
        String fileName = context.getLogFilePath();
        context.getExplorationOutcome().ifPresentOrElse( outcome -> {
                    stringList.add( getMessageIfPresent(context, outcome ) );
                    writeMessageToFile( fileName );
                }, () -> stringList.add( getMessageIfEmpty( context ) ) );
    }

    private String getMessageIfEmpty(Context context) {
        return "STEP " + context.getStepNumber() + "; " + "EVENT position; UNIT " + context.getRover().getId() + "; " + "POSITION " + context.getRover().getCurrentPosition() + "\n";
    }

    private String getMessageIfPresent(Context context, Outcome outcome) {
        return "STEP " + context.getStepNumber() + "; " + "EVENT outcome; UNIT " + context.getRover().getId() + "; " + "OUTCOME " + outcome + "\n";
    }

    private void writeMessageToFile(String fileName) {
        FileWriter fileWriter = new FileWriter( stringList );
        fileWriter.writeLogFile( fileName );
    }
}
