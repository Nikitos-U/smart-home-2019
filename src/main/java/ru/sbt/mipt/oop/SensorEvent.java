package ru.sbt.mipt.oop;

public class SensorEvent {
    private final SensorEventType type;
    private final String objectId;
    private final String secretCode;

    public SensorEvent(SensorEventType type, String objectId, String secretCode) {
        this.type = type;
        this.objectId = objectId;
        this.secretCode = secretCode;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getSecretCode() {
        return secretCode;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                ", secretCode= " + secretCode +
                '}';
    }
}
