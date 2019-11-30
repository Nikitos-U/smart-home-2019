package ru.sbt.mipt.oop;

import java.util.logging.Handler;

import static ru.sbt.mipt.oop.FakeSensorEventsGenerator.getNextSensorEvent;
import static ru.sbt.mipt.oop.SensorEventType.*;

class EventManager {
    static void processEvent(SmartHome smartHome) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            SensorEventType type = event.getType();
            for (HandlerType handlerType : HandlerType.values() ) {
                EventHandler eventHandler = handlerType.getEventHandler();
                eventHandler.handle(event, smartHome);
            }
            event = getNextSensorEvent();
        }
    }
}

