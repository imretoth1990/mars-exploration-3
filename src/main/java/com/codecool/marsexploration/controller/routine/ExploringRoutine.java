package com.codecool.marsexploration.controller.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

public class ExploringRoutine implements Routine {

    @Override
    public void move(Context context) {
        Coordinate currentPosition = context.getRover().getCurrentPosition();
        setPositionOfRover(currentPosition, context);
    }

    private void setPositionOfRover(Coordinate positionOfRover, Context context) {
        context.getRover().setCurrentPosition(new Coordinate(positionOfRover.x(), positionOfRover.y()+1));
    }
}
