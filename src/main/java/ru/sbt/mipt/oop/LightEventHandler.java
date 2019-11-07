package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

class LightEventHandler implements EventHandler {
    @Override
    public void run(SensorEventType type, String objectId, SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(objectId)) {
                    if (type == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else if (type == LIGHT_OFF) {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}
