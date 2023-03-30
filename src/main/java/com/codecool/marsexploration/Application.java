package com.codecool.marsexploration;

import com.codecool.marsexploration.controller.ExplorationSimulator;
import com.codecool.marsexploration.controller.jdbc.JDBCConnect;
import com.codecool.marsexploration.controller.jdbc.OutcomeTableManager;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;
import com.codecool.marsexploration.data.phase.PhaseManager;
import com.codecool.marsexploration.view.Display;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                new Coordinate( 12, 12 ),
                500,
                "src/main/resources/exploration-1.log" );

        PhaseManager phaseManager = new PhaseManager( new ArrayList<>() );

        Context context = new Context( Optional.empty() );

        DataPresenter presenter = new DataPresenter( phaseManager, context, input );
        presenter.initPhaseManager();
        presenter.initContext();
        presenter.createMarsMap();

        Display display = new Display( context );

        JDBCConnect connectionToDB = new JDBCConnect( "jdbc:postgresql://localhost:5432/mars_exploration" );
        Connection connection = connectionToDB.connect();
        OutcomeTableManager OutcomeTableManager = new OutcomeTableManager( connection, presenter );

        ExplorationSimulator simulator = new ExplorationSimulator( presenter, display, OutcomeTableManager );
        simulator.simulate();
    }
}
