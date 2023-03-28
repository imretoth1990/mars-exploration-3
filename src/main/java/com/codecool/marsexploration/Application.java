package com.codecool.marsexploration;

import com.codecool.marsexploration.data.datacontroller.DataPresenter;
import com.codecool.marsexploration.view.Display;
import com.codecool.marsexploration.controller.ExplorationSimulator;
import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.phase.PhaseManager;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        SimulationInput input = new SimulationInput(
                "src/main/resources/exploration-1.map",
                new Coordinate( 12, 12 ),
                100,
                "src/main/resources/exploration-1.log" );
        PhaseManager phaseManager = new PhaseManager( new ArrayList<>() );
        Context context = new Context();
        DataPresenter presenter = new DataPresenter( phaseManager, context, input );
        presenter.initPhaseManager();
        presenter.initContext();
        presenter.createMarsMap();
        Display display = new Display( context );
        ExplorationSimulator simulator = new ExplorationSimulator( presenter, display );
        simulator.simulate();
    }
}
