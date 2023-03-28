package com.codecool.marsexploration.controller;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.data.phase.PhaseManager;
import com.codecool.marsexploration.controller.fileoperator.FileReader;
import com.codecool.marsexploration.controller.phase.*;

import java.util.List;

public class DataPresenter {
    PhaseManager phaseManager;
    Context context;
    SimulationInput input;

    public DataPresenter(PhaseManager phaseManager,
                         Context context,
                         SimulationInput input) {
        this.phaseManager = phaseManager;
        this.context = context;
        this.input = input;
    }

    public void initPhaseManager() {
        phaseManager.phases().add(new Movement());
        phaseManager.phases().add(new Scan());
        phaseManager.phases().add(new Analysis());
        phaseManager.phases().add(new Log());
        phaseManager.phases().add(new StepIncrement());
    }

    public List<Phase> presentPhaseManager() {
        return phaseManager.phases();
    }

    public void initContext() {
            context.setLanding(input.landing());
            context.setTimeout(input.timeout());
            context.setLogFilePath(input.logPath());
    }

    public Context presentContext() {
        return context;
    }

    public void createMarsMap() {
        FileReader fileReader = new FileReader(input.mapPath());
        for (List<String> s : fileReader.readFile()) {
            System.out.println(s.toString());
        }
        context.setMap(fileReader.readFile());
    }
}
