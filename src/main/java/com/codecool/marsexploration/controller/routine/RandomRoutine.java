package com.codecool.marsexploration.controller.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.Random;

public class RandomRoutine implements Routine {
    Random random = new Random();

    @Override
    public void move(Context context) {
        Coordinate newCoordinate = getCoordinate(context);
        System.out.println( newCoordinate );
        context.getRover().setCurrentPosition(newCoordinate);
        context.getRover().getPositionCollector().positions().add(newCoordinate);
    }

    private Coordinate getCoordinate(Context context) {
        int x = generateRandomNumber( context.getMap().size() );
        int y = generateRandomNumber( context.getMap().get( 0 ).size() );
        return new Coordinate( x, y );
    }

    public int generateRandomNumber(int listSize) {
        return random.nextInt(listSize);
    }
}
