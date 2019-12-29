package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.SensorEvents.SensorEvent;
import ru.sbt.mipt.oop.eventHandlers.EventHandler;
import ru.sbt.mipt.oop.eventHandlers.HandlerType;

public class EventManager implements EventHandler {
    @Override
    public void handle(SensorEvent event, SmartHome smartHome) {
        System.out.println("Got event: " + event);
        for (HandlerType handlerType : HandlerType.values()) {
            EventHandler eventHandler = handlerType.getEventHandler();
            eventHandler.handle(event, smartHome);
        }
    }
}

