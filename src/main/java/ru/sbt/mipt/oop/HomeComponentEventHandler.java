package ru.sbt.mipt.oop;

public class HomeComponentEventHandler {
    SensorEvent event;

    public HomeComponentEventHandler(SensorEvent event) {
        this.event = event;
    }

    public void handle(SmartHome smartHome){
        smartHome.execute(this.event);
    }
}
