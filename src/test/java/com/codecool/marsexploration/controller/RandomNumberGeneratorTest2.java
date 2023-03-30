package com.codecool.marsexploration.controller;

import com.codecool.marsexploration.controller.routine.RandomRoutine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomNumberGeneratorTest2 {

    RandomRoutine randomRoutine = new RandomRoutine();

    @Test
    void testIfGeneratedNumberBetween0AndListSize() {
        int listSize = 5;
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testList.add( randomRoutine.generateRandomNumber( listSize ) );
        }

        for (int i = 0; i < testList.size(); i++) {
            assertTrue( checkNumber( testList.get( i ), listSize ) );
        }
    }

    public boolean checkNumber(int number, int listSize) {
        if (number >= 0 && number < listSize) return true;
        else return false;
    }
}