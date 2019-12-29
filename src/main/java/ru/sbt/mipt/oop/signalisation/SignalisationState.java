package ru.sbt.mipt.oop.signalisation;
import ru.sbt.mipt.oop.*;

public interface SignalisationState {
    void activate(String someCode);
    void deactivate(String someCode);
    void toAlarmState();
}
