package com.codecool.marsexploration.controller.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

public class Analysis implements Phase{
    @Override
    public void perform(Context context) {
       int amountOfMineral = context.getRover().getObjectCollector().mineralList().size();
       int amountOfWater = context.getRover().getObjectCollector().waterList().size();
       if(amountOfMineral >= 4 && amountOfWater >= 3) {
           context.setExplorationOutcome( Outcome.COLONIZABLE );
       } if (context.getStepNumber() > context.getTimeout()) {
           context.setExplorationOutcome( Outcome.TIMEOUT );
        }
    }
}
