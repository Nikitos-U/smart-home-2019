package ru.sbt.mipt.oop.SensorEvents;

import ru.sbt.mipt.oop.SensorEventType;

public class NoSecretCodeEvent extends SensorEvent {
    public NoSecretCodeEvent(SensorEventType type, String objectId) {
        super(type, objectId);
    }

    @Override
    public String getSecretCode() {
        return null;
    }
}
