package com.codecool.marsexploration.controller.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

public class ZigZagRoutine implements Routine {

    @Override
    public void move(Context context) {
        Coordinate newCoordinate = getCoordinate( context );
        System.out.println( newCoordinate );
        context.getRover().setCurrentPosition( newCoordinate );
        context.getRover().getPositionCollector().positions().add( newCoordinate );
    }

    private Coordinate getCoordinate(Context context) {
        Coordinate currentPosition = context.getRover().getCurrentPosition();
        int x = currentPosition.x();
        int y = currentPosition.y();

        if (x < context.getMap().size() / 2) {
            if (x % 2 == 0) {
                if (y < context.getMap().get( x ).size()) {
                    y += 1;
                } else {
                    x += 1;
                }
            }
            if (x % 2 == 1) {
                if (y > 0) {
                    y -= 1;
                } else {
                    x += 1;
                }
            }
        } else {
            x = 0;
        }

        if (y == context.getMap().get( x ).size()) {
            x += 1;
            y -= 1;
        }

        Coordinate newCoordinate = new Coordinate( x, y );
        return newCoordinate;
    }
}
