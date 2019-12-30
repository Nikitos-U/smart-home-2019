package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;
    private String roomName;

    public Door(boolean isOpen, String id, String roomName) {
        this.isOpen = isOpen;
        this.id = id;
        this.roomName = roomName;
    }

    public String getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void execute(Action action) {
        action.execute(this);
    }

    public String getRoomName() {
        return roomName;
    }

}

