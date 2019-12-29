package ru.sbt.mipt.oop.SensorEvents;

import ru.sbt.mipt.oop.SensorEventType;

public class AlarmSensorEvent extends SensorEvent {
    private final String secretCode;

    public AlarmSensorEvent(SensorEventType type, String objectId, String secretCode) {
        super(type, objectId);
        this.secretCode = secretCode;
    }

    public String getSecretCode() {
        return secretCode;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type = " + getType() +
                ", secretCode = " + getSecretCode() +
                '}';
    }
}
