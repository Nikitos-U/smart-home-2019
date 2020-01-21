package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public interface EventHandler {
    void handle(SensorEvent event);
}
