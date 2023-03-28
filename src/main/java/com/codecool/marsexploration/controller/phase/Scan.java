package com.codecool.marsexploration.controller.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;

public class Scan implements Phase{
    @Override
    public void perform(Context context) {
        Coordinate currentPosition = context.getRover().getCurrentPosition();
        String field = context.getMap().get( currentPosition.x() ).get( currentPosition.y() );
        if (field.contains( Symbol.WATER.getSymbol() )) {
            context.getRover().getObjectCollector().waterList().add( currentPosition );
        } else if (field.contains( Symbol.MINERAL.getSymbol() )) {
            context.getRover().getObjectCollector().mineralList().add( currentPosition );
        }
    }
}
