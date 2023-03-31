package com.codecool.marsexploration;

import com.codecool.marsexploration.controller.ExplorationSimulator;
import com.codecool.marsexploration.controller.jdbc.*;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;
import com.codecool.marsexploration.data.phase.PhaseManager;
import com.codecool.marsexploration.view.Display;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-2.map",
                new Coordinate( 12, 12 ),
                300,
                "src/main/resources/exploration-2.log" );

        PhaseManager phaseManager = new PhaseManager( new ArrayList<>() );

        Context context = new Context( Optional.empty() );

        DataPresenter presenter = new DataPresenter( phaseManager, context, input );
        presenter.initPhaseManager();
        presenter.initContext();
        presenter.createMarsMap();

        Display display = new Display( context );

        JDBCConnect connectionToDB = new JDBCConnect( "jdbc:postgresql://localhost:5432/mars_exploration" );
        Connection connection = connectionToDB.connect();
        JDBCManager outcome = new OutcomeTableManager( connection, presenter );
        JDBCManager map = new MapTableManager( connection, presenter );
        JDBCManager resource = new ResourcesTableManager( connection, presenter );
        List<JDBCManager> jdbcManagerList = List.of(outcome, map, resource);

        ExplorationSimulator simulator = new ExplorationSimulator( presenter, display, jdbcManagerList);
        simulator.simulate();
    }
}
