package com.codecool.marsexploration.controller.routine;

import com.codecool.marsexploration.data.Context;

public class ReturningRoutine implements Routine {

    @Override
    public void move(Context context) {
        context.getRover().setCurrentPosition(context.getLanding());
    }
}
