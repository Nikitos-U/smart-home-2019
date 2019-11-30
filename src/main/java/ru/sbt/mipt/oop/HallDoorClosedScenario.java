package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class HallDoorClosedScenario implements EventHandler {

    @Override
    public void handle(SensorEvent event, SmartHome smartHome) {
        Action action;
        if (event.getType() != DOOR_CLOSED) {
            action = null;
        } else {
            action = o -> {
                if (!(o instanceof Door)){
                    return;
                }
                Door door = (Door) o;
                if (door.getId().equals(event.getObjectId())) {
                    if (door.getRoomName().equals("hall")) {
                        if (!door.isOpen()) {
                            Action lightsOff = o1 -> {
                                if (!(o1 instanceof Light)) {
                                    return;
                                }
                                Light light = (Light) o1;
                                light.setOn(false);
                            };
                            smartHome.execute(lightsOff);
                        }
                        System.out.println("All lights were turned off.");
                    }
                }
            };
        }
        if (action != null) {
            smartHome.execute(action);
        }
    }
}
