package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class Door implements Actionable {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public boolean execute(SensorEvent event) {
        if (this.id.equals(event.getObjectId())) {
            if (event.getType() == DOOR_OPEN) {
                this.setOpen(true);
                System.out.print("Door " + this.getId() + " was opened");
                return true;
            } else {
                this.setOpen(false);
                System.out.print("Door " + this.getId() +  " was closed");
                return true;
            }
        }
        return false;
    }
}
