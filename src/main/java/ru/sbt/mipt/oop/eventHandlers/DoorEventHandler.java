package ru.sbt.mipt.oop.eventHandlers;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class DoorEventHandler implements EventHandler {
    private SmartHome smartHome;

    public DoorEventHandler(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    public DoorEventHandler() {
    }

    @Override
    public void handle(SensorEvent event) {
        Action action;
        if (event == null){
            return;
        }
        if (event.getType() != DOOR_OPEN && event.getType() != DOOR_CLOSED) {
            action = null;
        } else {
            action = new Action() {
                @Override
                public void execute(Object o) {
                    if (!(o instanceof Door)) {
                        return;
                    }
                    Door door = (Door) o;
                    if (door.getId().equals(event.getObjectId())) {
                        if (event.getType() == DOOR_OPEN) {
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room " + door.getRoomName() + " was opened.");
                        } else {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + door.getRoomName() + " was closed.");
                        }
                    }
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }
}
