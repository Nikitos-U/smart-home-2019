package ru.sbt.mipt.oop;

public enum SensorEventType {
    LIGHT_ON , LIGHT_OFF, DOOR_OPEN, DOOR_CLOSED, ALARM_ACTIVATE, ALARM_DEACTIVATE;
    private String secretCode;

    SensorEventType(String secretCode) {
        this.secretCode = secretCode;
    }

    SensorEventType() {
    }

    public String getSecretCode() {
        return secretCode;
    }
}
