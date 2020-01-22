package ru.sbt.mipt.oop.Adapters;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import com.coolcompany.smarthome.events.CCSensorEvent;

public interface SensorEventConverter {
    SensorEvent convert(CCSensorEvent event);
}
