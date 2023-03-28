package com.codecool.marsexploration.controller.phase;

import com.codecool.marsexploration.data.Context;

public class StepIncrement implements Phase{
    @Override
    public void perform(Context context) {
        int step = context.getStepNumber();
        context.setStepNumber( step + 1);
    }
}
