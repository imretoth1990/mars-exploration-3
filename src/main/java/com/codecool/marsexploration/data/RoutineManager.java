package com.codecool.marsexploration.data;

import com.codecool.marsexploration.controller.routine.ExploringRoutine;
import com.codecool.marsexploration.controller.routine.RandomRoutine;
import com.codecool.marsexploration.controller.routine.ReturningRoutine;
import com.codecool.marsexploration.controller.routine.Routine;

public enum RoutineManager {
    RANDOM_ROUTINE( new RandomRoutine() ),
    RETURNING_ROUTINE( new ReturningRoutine() ),
    EXPLORING_ROUTINE( new ExploringRoutine() );

    Routine routine;

    RoutineManager(Routine routine) {
        this.routine = routine;
    }

    public Routine getRoutine() {
        return routine;
    }
}
