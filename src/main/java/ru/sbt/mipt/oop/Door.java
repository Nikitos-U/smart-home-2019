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
    public void execute(SensorEvent event) {

        if (this.id.equals(event.getObjectId())) {
            if (event.getType() == DOOR_OPEN) {
                this.setOpen(true);
                System.out.println("Door " + this.getId() + " in room " + Room.getName(event.getObjectId()) + " was opened.");
            } else {
                this.setOpen(false);
                System.out.println("Door " + this.getId() + " in room " + Room.getName(event.getObjectId()) + " was closed.");
                // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)

            }
        }
    }
}
