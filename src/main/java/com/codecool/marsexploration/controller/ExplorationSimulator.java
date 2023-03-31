package com.codecool.marsexploration.controller;

import com.codecool.marsexploration.controller.jdbc.JDBCManager;
import com.codecool.marsexploration.controller.jdbc.OutcomeTableManager;
import com.codecool.marsexploration.controller.phase.Phase;
import com.codecool.marsexploration.controller.routine.Routine;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.RoutineManager;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.data.collectors.ObjectCollector;
import com.codecool.marsexploration.data.collectors.PositionCollector;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;
import com.codecool.marsexploration.view.Display;

import java.util.ArrayList;
import java.util.List;

public class ExplorationSimulator {
    DataPresenter presenter;
    Context context;
    Display display;
    List<JDBCManager> jdbcManagerList;

    public ExplorationSimulator(DataPresenter presenter, Display display, List<JDBCManager> jdbcManagerList) {
        this.presenter = presenter;
        this.context = presenter.presentContext();
        this.display = display;
        this.jdbcManagerList =jdbcManagerList;
    }

    public void simulate() {
        Rover volvoMR1 = new Rover( "Volvo-MR01", context.getLanding(), 1000, new PositionCollector( new ArrayList<>() ), new ObjectCollector( new ArrayList<>(), new ArrayList<>() ) );
        context.setRover( volvoMR1 );
        context.getRover().setRoutine( RoutineManager.RANDOM_ROUTINE.getRoutine() );
        runProcess( RoutineManager.RETURNING_ROUTINE.getRoutine() );
        display.displayProcess();

        //jdbcManagerList.forEach( jdbcManager -> jdbcManager.createTable() );
        jdbcManagerList.forEach( jdbcManager -> jdbcManager.insertDataIntoTable() );

        display.displayProcess();
    }

    private void makeStep() {
        for (Phase phase : presenter.presentPhaseManager()) {
            phase.perform( context );
        }
    }

    private void runProcess(Routine returnRoutine) {
        while (context.getExplorationOutcome().isEmpty()) {
            if (context.getStepNumber() == context.getTimeout()) {
                context.getRover().setRoutine( returnRoutine );
            }
            makeStep();
        }
    }
}
