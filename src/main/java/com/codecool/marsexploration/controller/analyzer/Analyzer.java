package com.codecool.marsexploration.controller.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Outcome;

import java.util.Optional;

public interface Analyzer {
    Optional<Outcome> analyze(Context context);
}
