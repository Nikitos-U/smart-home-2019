package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class Light implements Actionable{
    private String roomName;
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn, String roomName) {
        this.id = id;
        this.isOn = isOn;
        this.roomName = roomName;
    }

    public boolean isOn() {
        return isOn;
    }

    String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getRoomName() {
        return roomName;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }
}
