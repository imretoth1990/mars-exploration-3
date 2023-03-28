package com.codecool.marsexploration.controller.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.controller.routine.Routine;

public class Movement implements Phase {

    @Override
    public void perform(Context context) {
        Routine routine = context.getRover().getRoutine();
        routine.move(context);
    }
}
