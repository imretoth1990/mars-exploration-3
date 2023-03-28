package com.codecool.marsexploration.data;

import java.util.List;
import java.util.Optional;

public class Context {
    private int stepNumber;
    private long timeout;
    private List<List<String>> marsMap;
    private Coordinate landing;
    private Rover rover;
    private Outcome explorationOutcome; // return Optional
    private String logFilePath;

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public List<List<String>> getMap() {
        return marsMap;
    }

    public void setMap(List<List<String>> marsMap) {
        this.marsMap = marsMap;
    }

    public Coordinate getLanding() {
        return landing;
    }

    public void setLanding(Coordinate landing) {
        this.landing = landing;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Optional<Outcome> getExplorationOutcome() {
        if (explorationOutcome == null) {
            return Optional.empty();
        } else {
            return Optional.of( explorationOutcome );
        }
    }

    public void setExplorationOutcome(Outcome explorationOutcome) {
        this.explorationOutcome = explorationOutcome;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }
}
