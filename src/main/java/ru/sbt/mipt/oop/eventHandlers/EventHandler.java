package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public interface EventHandler {
    void handle(SensorEvent event, SmartHome smartHome);
}
