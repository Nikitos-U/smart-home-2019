package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.library.events.CCSensorEvent;

public interface EventHandler {
    void handle(SensorEvent event);
}
