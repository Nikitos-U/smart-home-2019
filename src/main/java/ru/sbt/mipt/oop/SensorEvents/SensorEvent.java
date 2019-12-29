package ru.sbt.mipt.oop.SensorEvents;

import ru.sbt.mipt.oop.SensorEventType;

public abstract class SensorEvent {
    private final SensorEventType type;
    private final String objectId;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    public abstract String getSecretCode();

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type = " + type +
                ", objectId = " + objectId +
                '}';
    }
}
