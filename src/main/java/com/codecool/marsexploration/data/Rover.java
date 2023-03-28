package com.codecool.marsexploration.data;

import com.codecool.marsexploration.data.collectors.ObjectCollector;
import com.codecool.marsexploration.data.collectors.PositionCollector;
import com.codecool.marsexploration.controller.routine.Routine;

public class Rover {
    private String id;
    private Coordinate position;
    private int sight;
    private Routine routine;
    private PositionCollector previousPositions;
    private ObjectCollector interestingObjectsWithCoordinates;

    public Rover(String id, Coordinate landing, int sight, PositionCollector previousPositions, ObjectCollector interestingObjectsWithCoordinates) {
        this.id = id;
        this.position = landing;
        this.sight = sight;
        this.previousPositions = previousPositions;
        this.interestingObjectsWithCoordinates = interestingObjectsWithCoordinates;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public void setCurrentPosition(Coordinate position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public Coordinate getCurrentPosition() {
        return position;
    }

    public int getSight() {
        return sight;
    }

    public Routine getRoutine() {
        return routine;
    }

    public PositionCollector getPositionCollector() {
        return previousPositions;
    }

    public ObjectCollector getObjectCollector() {
        return interestingObjectsWithCoordinates;
    }
}
