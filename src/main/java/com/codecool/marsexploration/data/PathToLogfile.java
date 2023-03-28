package com.codecool.marsexploration.data;

public enum PathToLogfile {
    URL("src/main/resources/");    // extend path with file name
    String path;

    PathToLogfile(String path) {
        this.path = path;
    }
}
