package ru.sbt.mipt.oop.signalisation;
import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;

public interface SignalisationState {
    void activate(String someCode);
    void deactivate(SensorEvent event);
    void toAlarmState();
}
