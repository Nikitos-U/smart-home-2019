package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEvent.getNextSensorEvent;
import static ru.sbt.mipt.oop.SensorEventType.*;

class EventManager {
    static void processEvent(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            SensorEventType type = event.getType();
            type.createHandler(type, event.getObjectId(), smartHome);
            event = SensorEvent.getNextSensorEvent();
        }
    }


    static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
}

