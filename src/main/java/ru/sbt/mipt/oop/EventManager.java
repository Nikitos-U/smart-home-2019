package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.eventHandlers.AlarmDecorator;
import ru.sbt.mipt.oop.eventHandlers.EventHandler;
import ru.sbt.mipt.oop.eventHandlers.HandlerType;

import static ru.sbt.mipt.oop.FakeSensorEventsGenerator.getNextSensorEvent;

public class EventManager {
    public static void processEvent(SensorEvent event, SmartHome smartHome) {
        System.out.println("Got event: " + event);
        for (HandlerType handlerType : HandlerType.values()) {
            EventHandler eventHandler = handlerType.getEventHandler();
            eventHandler.handle(event, smartHome);
        }
    }
}

