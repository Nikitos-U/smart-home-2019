package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.library.events.CCSensorEvent;

public interface SensorEventAdapter {
    SensorEvent adaptee(CCSensorEvent event);
}
