package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

class LightEventHandler extends EventHandler {
    public LightEventHandler(SensorEventType type, String objectId,SmartHome smartHome) {
        super(type,objectId,smartHome);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(objectId)) {
                    if (type == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}
