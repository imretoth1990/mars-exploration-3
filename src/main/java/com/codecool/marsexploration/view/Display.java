package com.codecool.marsexploration.view;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;

import java.util.List;
import java.util.Optional;

public class Display {
    Context context;

    public Display(Context context) {
        this.context = context;
    }

    public void displayProcess() {
        writeOutCoordinates( "Water", context.getRover().getObjectCollector().waterList() );
        writeOutCoordinates( "Mineral", context.getRover().getObjectCollector().mineralList() );
        writeOutExplorationOutcome();
    }

    private void writeOutCoordinates(String name, List<Coordinate> list) {
        System.out.println();
        System.out.println( "Number of found " + name + "s: " + list.size() );
        for (Coordinate coordinate : list) {
            System.out.println( name + ": " + coordinate );
        }
    }

    private void writeOutExplorationOutcome() {
        Optional<Outcome> findOutcome = context.getExplorationOutcome();
        findOutcome.ifPresent( outcome -> {
            System.out.println();
            System.out.println( "ExplorationOutcome: " + outcome );
        } );

    }
}
