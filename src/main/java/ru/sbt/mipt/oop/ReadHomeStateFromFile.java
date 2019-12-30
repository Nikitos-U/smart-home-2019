package ru.sbt.mipt.oop;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class ReadHomeStateFromFile implements ReadHomeState {
    private String fileName;

    public ReadHomeStateFromFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SmartHome readCondition(){
        Gson gson = new Gson();
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SmartHome smartHome = gson.fromJson(json, SmartHome.class);
        return smartHome;
    }
}