package com.codecool.marsexploration.controller.fileoperator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriter {
    List<String> stringList;

    public FileWriter(List<String> stringList) {
        this.stringList = stringList;
    }

    public void writeLogFile(String fileName) {
        try {
            java.io.FileWriter logWriter = new java.io.FileWriter(fileName);
            BufferedWriter log = new BufferedWriter(logWriter);
            for (String s : stringList) {
                log.write(s);
            }
            log.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
