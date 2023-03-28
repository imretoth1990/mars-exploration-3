package com.codecool.marsexploration.controller.fileoperator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private String url;

    private List<List<String>> stringList = new ArrayList<>();

    public FileReader(String url) {
        this.url = url;
    }

    public List<List<String>> readFile() {
        try {
            File file = new File(url);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> list = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == ' ') {
                        list.add(" ");
                    } else {
                        list.add(String.valueOf((line.charAt(i))));
                    }
                }
                stringList.add(list);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return stringList;
    }
}
